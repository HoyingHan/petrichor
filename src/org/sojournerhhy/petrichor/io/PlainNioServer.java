package org.sojournerhhy.petrichor.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/18
 */
public class PlainNioServer {
    public void serve(int port) throws IOException {
        System.out.println("Listening for connections on port " + port);

        //声明服务器端ServerSocketChannel通道
        ServerSocketChannel serverChannel;
        //声明一个多路复用器Selector
        Selector selector;

        serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ss.bind(address);

        serverChannel.configureBlocking(false);
        selector = Selector.open();

        /**
         * Registers this channel with the given selector, returning a selection
         * key.
         * The interest set for the resulting key
         */
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());

        while (true) {
            try {
                System.out.println(">>>>>等待感兴趣事件已经就绪的通道>>>>");
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }

            System.out.println(">>>>>返回就绪通道的键值>>>>>");
            Set readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        System.out.println("--该键表示的通道的Accept事件就绪--");
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
                    }
                    if (key.isWritable()) {
                        System.out.println("--该键表示的通道的Writable事件就绪--");
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        while (buffer.hasRemaining()) {
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client.close();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                    }
                }

                System.out.println("++++++++++++++++++++++++++++++++++++++++++\r\n");
            }
        }
    }

    public static void main(String args[]) throws IOException {
        int port = 8080;
        PlainNioServer plainNioServer = new PlainNioServer();
        plainNioServer.serve(port);
    }
}

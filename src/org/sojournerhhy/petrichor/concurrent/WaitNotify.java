package org.sojournerhhy.petrichor.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/13
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception{
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }


    static class Wait implements Runnable {
        public void run() {
            synchronized (lock) {
                while (flag) {

                    try {
                        System.out.println(Thread.currentThread() + "----flag is true. wait : " + new Date());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + "----flag is false. wait :" + new Date());
            }
        }
    }


    static class Notify implements Runnable {

        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "----hold lock. notify :" + new Date());
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (lock) {
                    System.out.println(Thread.currentThread() + "----hold lock again. notify :" + new Date());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}



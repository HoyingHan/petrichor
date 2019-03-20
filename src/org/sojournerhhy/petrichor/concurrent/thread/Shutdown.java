package org.sojournerhhy.petrichor.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/20
 */
public class Shutdown {


    private static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;

        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }


    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();


    }
}

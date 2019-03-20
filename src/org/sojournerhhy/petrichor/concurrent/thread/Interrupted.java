package org.sojournerhhy.petrichor.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/20
 */
public class Interrupted {


    static class SleepRunner implements Runnable {
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class BusyRunner implements Runnable {
        public void run() {
            while (true) {

            }
        }
    }





    public static void main(String[] args) throws Exception{
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
  //      sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
     //   busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
     //    sleepThread.interrupt();
      //   busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());



    }

}

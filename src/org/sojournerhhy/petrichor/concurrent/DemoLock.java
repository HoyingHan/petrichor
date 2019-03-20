package org.sojournerhhy.petrichor.concurrent;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/20
 */
public class DemoLock {


    private static String A = "A";

    private static String B = "B";


    private static void deadLockTest() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });

        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) {
        deadLockTest();
    }


}

package org.sojournerhhy.petrichor.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/5
 */
public class ThreadPoolTest {


    /**
     * 可缓存线程池，如果线程池长度超过处理需要，灵活回收空闲线程
     */
    public static void cacheThreadPoolTest() {

        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });

        }
    }


    /**
     * 定长线程池，可控制线程最大并发数，超出的线程在队列中等待
     */
    public static void fixThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }



    public static void scheduledThreadPoolTest() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }


    public static void scheduledThreadPoolTest2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, every 3 seconds ");
            }
        }, 1,3, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
       // cacheThreadPoolTest();
       // fixThreadPoolTest();
        scheduledThreadPoolTest2();
    }



}

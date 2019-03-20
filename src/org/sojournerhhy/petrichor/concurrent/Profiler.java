package org.sojournerhhy.petrichor.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/14
 */
public class Profiler {


    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");

    }

}

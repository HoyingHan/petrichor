package org.sojournerhhy.petrichor.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/20
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }


}

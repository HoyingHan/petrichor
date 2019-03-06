package org.sojournerhhy.petrichor.designpatterns.singleton;

/**
 * Description: 线程不安全 - 懒汉模式
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class SingletonTwo {

    private static SingletonTwo instance;

    private SingletonTwo() {

    }

    public static SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }



}

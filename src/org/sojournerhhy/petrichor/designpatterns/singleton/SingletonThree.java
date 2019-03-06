package org.sojournerhhy.petrichor.designpatterns.singleton;

/**
 * Description: 线程安全 - 懒汉模式
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class SingletonThree {


    private static SingletonThree instance;

    private SingletonThree(){

    }

    public static synchronized SingletonThree getInstance() {
        if (instance == null) {
            instance = new SingletonThree();
        }
        return instance;
    }

}

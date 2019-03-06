package org.sojournerhhy.petrichor.designpatterns.singleton;

/**
 * Description: 饿汉模式，类加载时完成初始化
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/6
 */
public class SingletonOne {


    private static SingletonOne instance = new SingletonOne();

    private SingletonOne() {

    }

    public static SingletonOne getInstance() {
        return instance;
    }
}

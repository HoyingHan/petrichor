package org.sojournerhhy.petrichor.designpatterns.singleton;

/**
 * Description: DCL
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class SingletonFour {

    private static SingletonFour instance;
    private SingletonFour(){

    }


    public static SingletonFour getInstance(){
        if (instance == null) {
            synchronized (SingletonFour.class) {
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }
        return instance;
    }





}

package org.sojournerhhy.petrichor.collection;

import java.util.HashMap;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/7
 */
public class HashMapTest {

    public static void main(String[] args) {

        HashMap<String, Integer> test = new HashMap<>(3);

        test.put("one", 1);
        test.put("two", 2);


        Integer res = test.get("one");
        System.out.println(res);

    }





}

package com.huster.leetcode.prepareForOffer.singletonCollection;

/**
 * @author Created by Divo
 * @date 2020/9/10
 * Description: 使用synchronized关键字
 * Status:finished
 */
public class Singleton1 {
    private Singleton1(){}

    private static Singleton1 singleton1;

    public static synchronized Singleton1 getInstance(){ //锁住整个类  静态的方法
        if (singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

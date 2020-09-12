package com.huster.leetcode.prepareForOffer.singletonCollection;

/**
 * @author Created by Divo
 * @date 2020/9/10
 * Description: 使用双重加锁来实现
 * Status:finished
 * Extra:see more details click<href>https://www.cnblogs.com/xz816111/p/8470048.html<href/>
 */
public class Singleton {
    private Singleton() {//private 访问级别的构造方法
    }

    private static volatile Singleton singleton;    //使用volatile修饰，提供可见性,禁止指令重排，
                                                    // 保证getInstance返回的是初始化完全的对象
    public static Singleton getInstance() {
        if (singleton == null) {  //尽量避免进入重复块
            synchronized (Singleton.class) {   //锁住class级别的
                if (singleton == null) {   //再次判断
                    singleton = new Singleton();     //error 这一行可以分为3个步骤
                }
            }
        }
        return singleton;
    }
}

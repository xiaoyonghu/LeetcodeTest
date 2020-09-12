package com.huster.leetcode.prepareForOffer.singletonCollection;

/**
 * @author Created by Divo
 * @date 2020/9/10
 * Description:使用静态内部类
 * Status:finished
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static class SingletonHolder {
        private static Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.singleton2;
    }

    //其理论依据是对象初始化过程中隐含的初始化锁（有兴趣的话你可以参考jls-12.4.2 中对 LC 的说明）
}

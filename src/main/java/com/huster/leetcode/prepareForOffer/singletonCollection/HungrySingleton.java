package com.huster.leetcode.prepareForOffer.singletonCollection;

/**
 * @author Created by Divo
 * @date 2020/9/10
 * Description:使用饿汉式
 * Status:finished
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}

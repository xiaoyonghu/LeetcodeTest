package com.huster.leetcode.prepareForOffer.testDemo;

/**
 * @author Created by Divo
 * @date 2020/10/12
 * Description:测试dog类的试题
 * Status:new
 */
public class testDog {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog b = new Dog();
        a.move();
        b.move();
        b.bark();//不是Dog类型需要强转
    }
}

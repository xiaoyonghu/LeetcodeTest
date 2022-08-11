package com.huster.leetcode.SwordToOffer.PartitionOne;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2022/8/10
 * Description:使用2个栈实现一个队列（三种情况A、B）
 * Status:new
 */
public class Test9 {

    //solution one
    // use two stack

//    Stack<Integer> A, B;
//
//    public Test9() {
//        A = new Stack<>();
//        B = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        A.push(value);
//    }
//
//    public int deleteHead() {
//        if (B.isEmpty()) {
//            while (!A.isEmpty()) {
//                B.push(A.pop());
//            }
//        }
//        return B.isEmpty() ? -1 : B.pop();
//    }

    // using two LinkedList
    LinkedList<Integer> A, B;

    public Test9() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        //思路一样
        if (B.isEmpty()) {
            while (!A.isEmpty()) {
                B.addLast(A.removeLast());
            }
        }
        return B.isEmpty() ? -1 : B.removeLast();

//        if(!B.isEmpty()) return B.removeLast();
//        if(A.isEmpty()) return -1;
//        while(!A.isEmpty())
//            B.addLast(A.removeLast());
//        return B.removeLast();

    }

    public static void main(String[] args) {

    }
}

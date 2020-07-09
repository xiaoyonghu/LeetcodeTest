package com.huster.leetcode.TeachingAssistantTask;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2019/10/12
 * Description:斐波那契数列的实现
 * Status:new
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        // TODO
        int a = 1;
        int b = 1;
        int c = 0;
        if(n==1 || n==2){
            System.out.print(1);
            return;
        }
        //把前面2个给第3个，然后前面2个都向后面移动一位即可
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.print(c);
    }
    }


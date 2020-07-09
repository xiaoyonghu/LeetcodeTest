package com.huster.leetcode.BaiduNewCoderTest;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:To Do
 * Status:new
 */
public class test10 {
    public static int gcd(int a, int b){
        while(b != 0){
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
    public static int lcm(int c, int d){
        return c*d/gcd(c,d);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        int max=0;
        int temp;
        for (int i = 1; i <= count ; i++) {
            for (int j= i+1;j <= count;j++){
              temp= lcm(i,j)-gcd(i,j);
              if (max<temp){
                  max=temp;
              }
            }
        }
        System.out.println(max);
    }
}

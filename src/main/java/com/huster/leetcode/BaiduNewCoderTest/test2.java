package com.huster.leetcode.BaiduNewCoderTest;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:用来求去掉一个点以后的最短距离
 * Status:new
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        int sum = 0;
        int max=0;
        if (count < 3)
            System.out.println("请至少输入3位数");
        int[] num=new int[count];
        for (int i = 0; i <count ; i++) {
            num[i]=sc.nextInt();
        }
        //求所有相连的2个节点的和
        for (int j = 1; j< count; j++) {
            sum += Math.abs(num[j]-num[j-1]);
        }
        //求重复距离的最大值 (a->b + b->c)- (a->c)
        for (int i = 0; i < count-2; i++) {
            max=Math.max(max,Math.abs(Math.abs(num[i+1]-num[i])+Math.abs(num[i+2]-num[i+1])-Math.abs(num[i+2]-num[i])));
        }
        System.out.println(sum);
        System.out.println(max);
        sum -= max;
        System.out.println(sum);
    }
}

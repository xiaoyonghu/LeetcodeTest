package com.huster.leetcode.BaiduNewCoderTest;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:To Do
 * Status:new
 */
public class test11 {
    private static int k=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }

    }
    public static  void fun(int[] arr,int n){
        if (check(arr,n)){
            return;
        }

    }
    public static boolean check(int[]arr ,int n){
        boolean ans=true;
        for (int i = 0; i <n ; i++) {
            if (arr[i]>=n){
                ans=false;
                break;
            }
        }
        return ans;
    }
}

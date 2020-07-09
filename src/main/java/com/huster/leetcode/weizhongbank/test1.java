package com.huster.leetcode.weizhongbank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description:人数 和 红包数相差，最少需要花费多少钱才能使每个人的礼物都相等
 * Status:new
 */
public class test1 {

    public static void main(String[] args) {
        //test1 test1=new test1();
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        ArrayList<Integer> arrayList=new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a=sc.nextInt();
            int d=sc.nextInt();
            arrayList.add(GetLeastMoney(n,m,a,d));
        }
        for (int j:arrayList){
            System.out.println(j);
        }

    }
    public static int GetLeastMoney(int n,int m,int a,int b){
        if (n<0||m<0||a<0||b<0)
            return -1;
        int gap=n-m; //人数-红包数
        if (gap==0)
            return 0;
        if (gap>0){
            return Math.min(a,b)*gap;
        }
        return 0;
    }

}

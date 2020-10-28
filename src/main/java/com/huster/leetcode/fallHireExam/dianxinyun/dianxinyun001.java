package com.huster.leetcode.fallHireExam.dianxinyun;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/15
 * Description:丑数  dp来做
 * Status:new
 */
public class dianxinyun001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < n; i++) {
            int t2 = dp[x]*2;
            int t3 = dp[y]*3;
            int t5 = dp[z]*5;
            dp[i] = Math.min(Math.min(t2,t3),t5); //取dp中的最小值
            if(dp[i] == t2) x++;  //移位
            if(dp[i] == t3) y++;
            if(dp[i] == t5) z++;
        }
        System.out.println(dp[n-1]);
    }
}

package com.huster.leetcode.fallHireExam.baidu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/3
 * Description: 爬楼梯问题 走的步数不能和前2步的一样
 * 思路：如果不能解决问题就得扩维
 * Status: finished
 */
public class Exam003 {
    static int count = 0;
    static List<Integer> list = new LinkedList<>();
    static final int mod = (int) (Math.pow(10, 9) + 7);
    static int[][][] dp;


    public static int taiJie(int n, int m) {
        dp = new int[n + 1][m + 1][m + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {   //dp(i,k,j) k当前走的步数，j之前走的步数
            for (int j = 0; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k == j)
                        continue;
                    for (int l = 0; l <= m; l++) { //l代表 之前之前的步骤
                        if (i - k == 0 && j == 0) {
                            dp[i][k][j] = 1; //初始化
                            continue;
                        }
                        if (l == k || i - k <= 0)
                            continue;
                        dp[i][k][j] += dp[i - k][j][l];
                        dp[i][k][j] %= mod;
                    }
                }
            }
        }
        int sum=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                sum += dp[n][i][j];
                sum %= mod;
            }
        }
        return sum;
    }

    //递归
//    private static void recusion(int n, int m, List<Integer> list, int step) {
//        if (step == n) {
//            count = (count % mod) + 1;
//        } else if (step > n) {
//            return;
//        } else {
//            for (int i = 1; i <= m; i++) {
//                if (i == list.get(list.size() - 1) || i == list.get(list.size() - 2)) {
//                    continue;
//                } else {
//                    list.add(i);
//                    dfs(n, m, list, step + i);
//                    list.remove(list.size() - 1);
//                }
//            }
//        }
    //  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m < 3)
            System.out.println("-1");
        System.out.println(taiJie(n, m));
    }
}

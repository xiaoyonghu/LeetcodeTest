package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 96 不同的二叉搜索树
 * Status:finished
 */
public class Exam96 {
    /**
     * 演变为了卡特兰数  G(n)=G(0)∗G(n−1)+G(1)∗G(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        //此时的i相当于n
        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j]; //统计n时的个数
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Exam96 exam96 = new Exam96();
        System.out.println(exam96.numTrees(3));

    }
}

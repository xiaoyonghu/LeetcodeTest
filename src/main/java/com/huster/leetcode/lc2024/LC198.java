package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 22:37
 * @Desc 打家劫舍 DP
 */
public class LC198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        // 12
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        // 1、dp定义 dp[i][0]不抢的最大值  dp[i][1]表示抢的最大值
        // 一个房间只有抢和不抢2种选择
        int[][] dp = new int[len][2];

        // 2、dp初始化
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        // 3、dp 转移方程
        for (int i = 1; i < len ; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}

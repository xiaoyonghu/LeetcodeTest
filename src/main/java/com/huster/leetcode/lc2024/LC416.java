package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 21:49
 * @Desc 分割等和子集
 * 规则：请你判断是否可以将这个数组分割成“两个”子集，使得两个子集的元素和相等。
 * 类似：0-1背包问题
 */

public class LC416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5}; // true [1,5,5] [11]
        LC416 lc416 = new LC416();
        System.out.println(lc416.canPartition(nums));

    }

    // 1.8号,无思路
    // 1.15号 无思路
    // 1.16号 看了题解
    // TODO:1.17号，解决
    // 1.19号 解决（先解决了0-1背包问题）
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            totalSum += nums[i];
        }
        // 无法拆分成2部分相等的
        if (totalSum % 2 == 1) return false;

        int target = totalSum/2;

        // 1、dp[i][j] 表示[0,i]前i个元素,选择其中的一些元素，使这些数的和恰好为j
        boolean[][] dp = new boolean[len][target + 1];
        // 2、初始化
        // dp[0][0]为false，因为第原始都为正整数，和不可能为0
        if (target >= nums[0]){
            dp[0][nums[0]] = true;
        }

        // 3、动态转移方程
        for (int i = 1; i < len; i++) { //第一行已经初始化完了
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j) {
                    // 不可能加上i对应元素，使其和能为j
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i] == j) {
                    // 0-i中，nums[i]已满足和为j
                    dp[i][j] = true;
                } else { //num[i]<j
                    //          不选               选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target]){ // 提前终止
                return true;
            }
        }
        return dp[len-1][target];
    }
}

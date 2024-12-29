package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 21:16
 * @Desc 乘积最大子数组 DP
 */
public class LC152 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {0, 2};
        int[] nums = {-3,-1,-1};
        System.out.println(maxProduct(nums));
    }

    /**
     * @Author Syong
     * @Description 使用最简单状态的dp
     **/
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        // dp定义
        // dp[i][0]表示使用i了以后得最大值，dp[i][1]表示使用i了以后得最小值
        // 当包含别的状态变量时，就是发现一维不够了，可以直接增加一维
        // dp状态初始化
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];

        // 状态装换方程
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                // 跟自身比较，是为了排除与0比较的情况
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]); // tips:这里可以优化
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}

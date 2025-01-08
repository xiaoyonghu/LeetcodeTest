package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/7 22:58
 * @Desc 跳跃游戏II
 */
public class LC045 {
    public static void main(String[] args) {
        // nums = [2,3,1,1,4]
//        int[] nums = {2, 3, 1, 1, 4}; // 2
        int[] nums = {2, 3, 0, 1, 4}; // 2
        System.out.println(jumpDP(nums));
    }

    // 使用DP
    // TimeConsume O(n*2) SpaceConsume O(N)
    public static int jumpDP(int[] nums) {
        int len = nums.length;
        // dp[i] 表示达到这里需要的最少步数
        int[] dp = new int[nums.length];

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i] = nums.length;
        }
        dp[0] = 0;

        // 动态转移方程
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= nums[j]) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[len - 1];
    }

    // 1.7 无思绪
    // 1.8 20:58 无思绪（贪心） 倒序-正序查找
    public static int jumpReverse(int[] nums) {
        int len = nums.length;
        int minStep = 0;
        int i = len - 1;
        while (i > 0) {
            // 找到第一个满足条件的（能调到i位置的）
            for (int j = 0; j < i; j++) {
                if (i - j <= nums[j]) {
                    minStep++;
                    i = j;
                    break;
                }
            }
        }
        return minStep;
    }

    // 贪心正序
    public static int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < len - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) { // 到达了最远距离
                steps++;
                end = farthest;
            }
        }
        return steps;
    }

}

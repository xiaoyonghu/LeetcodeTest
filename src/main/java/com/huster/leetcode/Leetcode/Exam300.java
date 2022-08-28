package com.huster.leetcode.Leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/7/25
 * Description:最长上升子序列 Exam94 300
 * Status:finished  动态规划
 */
public class Exam300 {
    //DP Time:O(n*2) Space:O(N)
    public int lengthOfLISS_DP(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLength = 1;
        int[] dp = new int[nums.length];
        //dp[i] : 到达 i节点是 最长的上升子序列的长度
        //初始化为1，最坏的情况是逆序
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            // dp[i] = Max(dp[j])+1 j--> 0 - i-1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > maxLength)
                maxLength = dp[i];
        }
        return maxLength;
    }

    //二分查找  Time:O(nlogn) Space:O(N)
    //tails[i-1] < x <= tails[i], update tails[i]
    //https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AE%BE%E8%AE%A1%EF%BC%9A%E6%9C%80%E9%95%BF%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.md
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     * 使用Java的内置函数
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            int i = Arrays.binarySearch(tails, 0, len, x);
            if (i < 0)
                i = -(i + 1);
            tails[i] = x;
            if (i == len) ++len;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        Exam300 exam300 = new Exam300();
        System.out.println(exam300.lengthOfLIS1(arr));
    }
}

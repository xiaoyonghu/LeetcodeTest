package com.huster.leetcode.lc2024;

import java.util.HashMap;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/15 20:57
 * @Desc 和为K的子数组
 * 规则：子数组是数组中元素的 “连续” 非空序列
 */
public class LC560 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1};
//        int[] nums = {1, 1, 1};
//        int[] nums = {1,2,1,2,1};
//        int[] nums = {1, -1, 0};
        int k = 0;
        LC560 lc560 = new LC560();
        System.out.println(lc560.subarraySum(nums, k));
    }

    // Solution2: 前缀和 + map
    // sum[i] - sum[j] = k ==> [j+1, i]的和为K
    // sum[i] 表示 sum(num[0] + ..nums[i])
    // TimeConsume:O(N)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // key:sum  value:count
        int totalSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
//            if (map.containsKey(totalSum)) {
//                map.put(totalSum, map.get(totalSum) + 1);
//            } else {
//                map.put(totalSum, 1);
//            }

            if (map.containsKey(totalSum - k)) { // 排除K=0的情况
                res += map.get(totalSum - k);
            }

            map.put(totalSum,
                    map.getOrDefault(totalSum, 0) + 1);
        }
        return res;
    }


    // Solution1: 2层for循环 暴力求解 TimeConsume O(N*2)
    public int subarraySumBaoli(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                res++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 算上第i位
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}

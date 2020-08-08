package com.huster.leetcode.Leetcode;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 560 和为K的子数组
 * Status:finished
 */
public class Exam560 {

    /**
     * 1、使用枚举法
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // Time:O(N)
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            //从后向前，可以囊括所有的子数组  Time:O(N)
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    /**
     * 2、使用技巧法
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        //       pre的值     pre出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}

package com.huster.leetcode.Leetcode;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/8/5
 * Description:lc 1 2数之和的问题
 * Status:finished
 */
public class Exam1 {
    //使用空间换时间
    //时间复杂度O(N)  空间复杂度O（N）
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)&& map.get(other)!=i)
                return new int[]{i,map.get(other)};
        }
        return new int[]{-1,-1};
    }
}

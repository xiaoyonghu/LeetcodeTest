package com.huster.leetcode.lc2024;

import java.util.HashMap;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/12 22:07
 * @Desc 2024刷题开端  两数之和
 */
public class LC001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 20;
        int[] res = twoSum(nums, target);
        System.out.println("one: "+ res[0] + ", two: "+ res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        // 1、2层for循环，O（n*2）
        // 2、使用map来存储，TimeConsume:O(n)  SpaceConsume:O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            map.put(nums[i], i);
//        }
//        for (int j = 0; j < len; j++) {
//            int gap = target - nums[j];
//            if (map.containsKey(gap) && j != map.get(gap)) {
//                return new int[]{j, map.get(gap)};
//            }
//        }


        for (int i = 0; i < len; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{i, map.get(gap)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}

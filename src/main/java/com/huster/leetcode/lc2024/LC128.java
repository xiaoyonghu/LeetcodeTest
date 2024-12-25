package com.huster.leetcode.lc2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/25 20:12
 * @Desc 最长连续序列  题目要求使用O（N）
 */
public class LC128 {

    public static void main(String[] args) {
         int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * @Author Syong
     * @Description  这种写法超出时间限制(得做剪切)
     **/
    public static int longestConsecutive(int[] nums) {
        // 1、使用map来存储，然后TimeConsume O(N)   SpaceConsume O(N)
        int len = nums.length;
        if (len == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int maxLength = 1;
        for (int i = 0; i < len; i++) {
            // 给的队列中无重复数字
            set.add(nums[i]);
        }
        //int[] nums = new int[]{100,4,200,1,3,2};
        for (int j = 0; j < len; j++) {  // O(N)
            int curNum = nums[j];
            int curLength = 1;
            if (!set.contains(curNum - 1)) {  // filter curNum-1
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLength++;
                }
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}

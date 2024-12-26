package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/25 22:37
 * @Desc 盛最多水的容器
 * @Type 双指针
 */
public class LC011 {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxAreaNotUsable(nums));
    }

    /**
     * @Description TimeConsume O(N*2)  测试case不能全部通过
     **/
    public static int maxAreaNotUsable(int[] height) {
        int maxArea = 0;
        int len = height.length;
        // O(N*2)
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                maxArea = Math.max(maxArea,
                        (j - i) * (Math.min(height[i], height[j])));
            }
        }
        return maxArea;
    }

    public static int maxAreaUsingDoublePoint(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(
                    maxArea, ((r - l) * Math.min(height[l], height[r])));
            // 保住最大边，移动最小边，创造无限可能
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

}

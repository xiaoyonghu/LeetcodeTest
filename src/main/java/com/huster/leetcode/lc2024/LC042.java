package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/26 20:01
 * @Desc 接雨水
 * 1、官方讲了3种解答方式
 * 第1和第3种都类似
 * 第二种使用单调递减栈，如果是比前面的低，就入站，如果比前面的高就出栈计算
 */
public class LC042 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }


    public static int trap(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int sum = 0;
        int leftMax = 0, rightMax = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > leftMax) {
                    leftMax = height[l];
                } else {
                    sum += (leftMax - height[l]);
                }
                l++;
            } else {
                if (height[r] > rightMax) {
                    rightMax = height[r];
                } else {
                    sum += (rightMax - height[r]);
                }
                r--;
            }
        }
        return sum;
    }


    /**
     * @Description 指针没使用到位
     **/
    @Deprecated
    public static int trapNotUsing(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int sum = 0;
        int leftMax = height[l], rightMax = height[r];
        while (l <= r) {
            if (leftMax > rightMax) { // 固定左边，移动右边
                while (l <= r && height[r] <= leftMax) { // 右边终止的条件是大于左边最大值
                    if (height[r] > height[r - 1]) {  // 如果下一个元素比当前小
                        sum += (rightMax - height[r - 1]); // 参与计算
                    } else {
                        rightMax = Math.max(rightMax, height[r - 1]); //取值
                    }
                    r--;
                }
            } else {
                while (l <= r && height[l] <= rightMax) {
                    if (height[l] > height[l + 1]) {
                        sum += (leftMax - height[l + 1]);
                    } else {
                        leftMax = Math.max(leftMax, height[l + 1]);
                    }
                    l++;
                }
            }
        }
        return sum;
    }
}

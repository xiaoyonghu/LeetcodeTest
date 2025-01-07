package com.huster.leetcode.lc2024;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/6 20:43
 * @Desc 跳跃游戏  贪心（贪心一般都需要使用算法去证明你这个是OK的）
 */
public class LC055 {
    public static void main(String[] args) {
        // nums = [2,3,1,1,4]  true
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3,2,1,0,4};
        // nums = [3,2,1,0,4]  false
        System.out.println(canJump(nums));
    }

    // 1.6 无思路
    // 1.7 自己写
    // 一种思路：
    //      从最后往前面走，后面坐标的值i与前面坐标j的值减，(i-j)且与前面的值nums[j]进行比较，
    //      如果大于，则表示j到达不了这里i（如果j前面的值都只能到j或者大不了则直接GG）
    // 规则：数组中的每个元素代表你在该位置可以跳跃的"最大长度"
    public static boolean canJumpBySelf(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = i - 1;
            if (i - j > nums[j]) {
                int k = j, m = j - 1;
                boolean flag = false;
                while (m >= 0) {
                    if (k - m < nums[m]) {
                        flag = true;
                        break;
                    }
                    m--;
                }
                if (flag == false) return false;
            }
        }
        return true;
    }

    // 1.7
    // 参看了题解
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        // 最后一步不需要跳跃
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次更新最远能到达的距离
            farthest = Math.max(farthest, i + nums[i]);
            // 遇到0了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }
}

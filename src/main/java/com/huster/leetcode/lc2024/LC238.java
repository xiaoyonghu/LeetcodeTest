package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/6 21:28
 * @Desc 除自身以外数组的乘积
 * 规则：请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class LC238 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};
        // 24,12,8,6
        // 1、思路：先乘以总的，然后对每个进行除以即可（如果有0就不行，这种思路就不行）
        // 2、不能除的话，使用异或，相当于除以了(不行)
        // 3、参看题解：前缀和后缀之积
        LC238 lc238 = new LC238();
        int[] result = lc238.productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " -> ");
        }

//        int totalSum = 1;
//        for (int i = 0; i < nums.length; i++) {
//            totalSum *= nums[i];
//        }
//        System.out.println(totalSum);
//        System.out.println(totalSum ^ (~nums[1]));

    }

    // 参看题解了的，但是了解了另外一种对于K系列问题的解法
    public int[] productExceptSelf(int[] nums) {
        // 使用前缀和后缀之积
        // int[] nums = {1, 2, 3, 4};
        // 前缀积 prefix = [1, 1, 2, 6]
        // 后缀积 suffix = [24, 12, 4, 1]
        // 乘积 [24, 12, 8, 6]
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] result = new int[len];
        int preSum = 1, sufSum = 1;
        // 使用3次for循环
        // 填充preSum
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                preSum *= nums[i - 1];
                prefix[i] = preSum;
            }
        }
        // 填充sufSum
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                suffix[i] = 1;
            } else {
                sufSum *= nums[i + 1];
                suffix[i] = sufSum;
            }
        }
        // 填充result
        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}

package com.huster.leetcode.lc2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/23 22:47
 * @Desc 三数之和    三指针 O（N*2）
 */
public class LC015 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(
                x ->{
                    System.out.println(x.get(0) +  ":" + x.get(1) +":"+ x.get(2));
                } );
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 1、采用三层for循环 O（N*3）
        // 2、先快排 o(nlog(N))，再使用双指针（也可以成为双指针） O（N*2）
        // 固定一个变量最左边的
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if ((i > 0) && (nums[i] == nums[i - 1])) //与前面计算的一轮的值相同
                continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                // 以i起点加起来为0的地方
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) { // 排除相同值
                        l++;
                    }
                    while (l < r && nums[r - 1] == nums[r]) { // 排除相同值
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[l + 1]) l++; //找到最后一个于其一样的
                    l++;
                } else {
                    while (l<r && nums[r-1] == nums[r]) r--; //找到最后一个于其一样的
                    r--;
                }
            }
        }
        return resList;
    }
}

package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/5
 * Description:Exam94 15 三数之和
 * Status:finished
 */
public class Exam15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //快排 nlogn
        //时间复杂度O(N*2)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // -2为后面留2个出来
        for (int i = 0; i < nums.length -2; i++) {
           if (nums[i]>0) break; //应用特性
           if ((i > 0) && (nums[i] == nums[i-1]))
               continue;
           int l=i+1, r=nums.length -1;
           while (l<r){
               int sum = nums[i]+nums[l]+ nums[r];
               if (sum < 0){
                   while (l<r && nums[l]== nums[l+1]) l++; //跳过重复值
                   l++;
               }
               else if(sum>0){
                   while (l<r && nums[r]== nums[r-1]) r--; //跳过重复值
                   r--;
               }
               else{
                   result.add(Arrays.asList(nums[i],nums[l], nums[r]));
                   while (l<r && nums[l]== nums[l+1]) l++;
                   while (l<r && nums[r]== nums[r-1]) r--;
                   l++;
                   r--;
               }
           }
        }

        return result;
    }
}

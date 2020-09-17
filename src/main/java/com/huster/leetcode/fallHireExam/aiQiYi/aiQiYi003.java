package com.huster.leetcode.fallHireExam.aiQiYi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description:To Do
 * Status:ac 100%
 */
public class aiQiYi003 {
    public static int[][] getZeroLists(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // -2为后面留2个出来
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; //应用特性
            if ((i > 0) && (nums[i] == nums[i - 1]))
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    while (l < r && nums[l] == nums[l + 1]) l++; //跳过重复值
                    l++;
                } else if (sum > 0) {
                    while (l < r && nums[r] == nums[r - 1]) r--; //跳过重复值
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }

        int len = result.size();
        int[][] result1 = new int[len][3];
        for (int i = 0; i < result.size(); i++) {
            List tmp = result.get(i);
            for (int j = 0; j < 3; j++) {
                result1[i][j] = (int) tmp.get(j);
            }
        }
        return result1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int len = s1.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int[][] show = getZeroLists(arr);
        for (int i = 0; i < show.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != 2) {
                    System.out.print(show[i][j] + " ");
                } else {
                    System.out.println(show[i][j] + " ");
                }
            }
        }
    }
}

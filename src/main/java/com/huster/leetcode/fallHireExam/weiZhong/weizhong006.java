package com.huster.leetcode.fallHireExam.weiZhong;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/10/15
 * Description:To Do
 * Status:new
 */
public class weizhong006 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        int len = 0;
        int k = 10;
        //int[] arr= new int[];
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            int tmp = n % k;  // 取每一位数
            list.add(tmp);
            n = n / k;
            len++; //表示长度
        }
        int[] arr = new int[len];
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            arr[index++] = list.get(i);
        }

        List<List<Integer>> res = permute(arr); //数组字符全排序

        int length = res.size();

        for (int i = 0; i < length; i++) {
            List<Integer> list1 = res.get(i);
            int totalLen = list1.size();
            int num = 0;
            for (int j = 0; j < totalLen; j++) {
                num += list1.get(j) * Math.pow(10, totalLen - j - 1);  //计算总数
            }
            if (!map.containsKey(num)) { //使用map来实现去重
                map.put(num, 1);
                if (num % m == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


}

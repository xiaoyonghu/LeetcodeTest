package com.huster.leetcode.Leetcode;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/29
 * Description:lc 214 最短回文串
 * Status:unfinished
 * kmp 马拉车算法
 */
public class Exam214 {
    /**
     * 下面这种思路解决的是找全局最短的
     */
    //思路一，可以与最长重复回文子串结合起来O（n）
    public String shortestPalindrome(String s) {
        int n = s.length();
        int arr[] = new int[2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            i = findLPSBased(chars, i, arr, n);
        }
        int left = arr[0];
        int right = arr[1];


        StringBuilder sb = new StringBuilder();
        int rLeft = n - right - 1;
        int lLeft = left;
        int temp = n - 1;

        //先加最长回文子串最右边的
        while (rLeft > 0) {
            sb.append(chars[temp--]);
            rLeft--;
        }

        //加入整个前面未匹配和最长回文子串
        for (int i = 0; i <= right; i++) {
            sb.append(chars[i]);
        }

        //加入最左边的未匹配
        temp = left - 1;
        while (lLeft > 0) {
            sb.append(chars[temp--]);
            lLeft--;
        }

        //加入最后末尾的
        for (int i = right + 1; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int findLPSBased(char[] chars, int low, int[] arr, int length) {
        //看成2部分，一部分为中间相等，另外一部分为旁边2边相等
        int high = low;
        while (high < length - 1 && (chars[high + 1] == chars[low])) {
            high++;
        }
        int ans = high;
        while (low > 0 && (high < length - 1) && chars[low - 1] == chars[high + 1]) {
            low--;
            high++;
        }
        if ((arr[1] - arr[0]) < (high - low)) {
            arr[1] = high;
            arr[0] = low;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exam214 exam214 = new Exam214();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(exam214.shortestPalindrome(s));
        }
        //System.out.println(s);
    }
}

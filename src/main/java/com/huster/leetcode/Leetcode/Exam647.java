package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/19
 * Description:lc 647 回文子串
 * Status:finished
 */
public class Exam647 {

    int sum = 0;

    public int countSubstrings(String s) {
        //以前找过最长回文子串，不是使用的dp lc5
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count(c, i, i);//回文为奇数
            count(c, i, i + 1); //回文为偶数
        }
        return sum;
    }

    private void count(char[] c, int start, int end) {
        while (start >= 0 && end < c.length && c[start] == c[end]) {
            sum++;
            //从中间向两边扩散
            start--;
            end++;
        }
    }
}

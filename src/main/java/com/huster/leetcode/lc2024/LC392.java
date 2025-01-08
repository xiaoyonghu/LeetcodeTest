package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 22:00
 * @Desc 判断子序列
 */
public class LC392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";  // true
    }

    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == len1;
    }
}

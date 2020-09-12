package com.huster.leetcode.utils;

import java.util.Arrays;

/**
 * @author Created by Divo
 * @date 2020/8/30
 * Description:kmp 代码测试
 * Status:unfinished
 */
public class Kmp {
    public void kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        //求得是next数组，数组的值并且是自定义的
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(fail[i]);
        }
    }

    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        kmp.kmp("ABABABABCABAAB", "ABABCABAA");
    }
}

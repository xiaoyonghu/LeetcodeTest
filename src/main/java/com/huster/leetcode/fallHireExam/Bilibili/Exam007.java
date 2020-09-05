package com.huster.leetcode.fallHireExam.Bilibili;

/**
 * @author Created by Divo
 * @date 2020/9/4
 * Description:对其中最长的片段求平均字段
 * Status:finished
 */
public class Exam007 {
    public int GetFragment(String str) {
        int n = str.length();
        if (str == null || n == 0)
            return 0;
        int split = 0, start = 0, end = 0;
        while (end < n) {
            while (end < n && str.charAt(start) == str.charAt(end)) {
                end++;
            }
            split++;
            start = end;
        }
        return n / split;
    }
}

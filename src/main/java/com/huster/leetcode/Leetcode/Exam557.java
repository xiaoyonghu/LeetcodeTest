package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Created by Divo
 * @date 2020/8/30
 * Description: lc 557 反转字符串中的单词III
 * Status:finished
 */
public class Exam557 {
    /**
     *  解法一：比较笨拙的解法
     */
    /**
     public String reverseWords(String s) {
     if (s.length() == 0 || s == null || s.length() == 1)
     return s;
     String[] s1 = s.split(" ");
     StringBuilder sb = new StringBuilder();
     for (int i = 0; i < s1.length; i++) {
     char[] c = s1[i].toCharArray();
     rev(c);
     if (i!=(s1.length-1)){
     for (char ch:c){
     sb.append(ch);
     }
     sb.append(" ");
     }else {
     for (char ch:c){
     sb.append(ch);
     }
     }
     }
     return sb.toString();
     }

     private void rev(char[] ss) {
     if (ss.length <= 0)
     return;
     int left = 0;
     int right = ss.length - 1;
     while (left <= right) {
     char temp = ss[right];
     ss[right] = ss[left];
     ss[left] = temp;
     left++;
     right--;
     }
     }
     */

    /**
     * 解法二：不用rev函数，直接用数字下标
     *
     * @return
     */
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int i = 0;

        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                res.append(s.charAt(start + i - 1 - j));//反向相加
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                res.append(' ');
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s2 = "东京 爱情 故事";
        Exam557 exam557 = new Exam557();
        System.out.println(exam557.reverseWords(s2));
    }
}

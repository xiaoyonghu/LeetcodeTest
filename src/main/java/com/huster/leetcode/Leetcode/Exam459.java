package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/30
 * Description:lc 459 重复的子字符串
 * Status:finished
 * 思路：KMP 理论推理
 */
public class Exam459 {
    //思路未理解
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, (s.length() * 2 - 1)).contains(s);
    }

}

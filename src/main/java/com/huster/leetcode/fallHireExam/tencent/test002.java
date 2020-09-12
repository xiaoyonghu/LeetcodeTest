package com.huster.leetcode.fallHireExam.tencent;

import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:解码问题，使用栈   面试太菜了
 * Status:unfinished
 */
public class test002 {
    public String getDecodeString(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>= 'A' && s.charAt(i)<='Z'){
                stack.push(s.charAt(i));
            }

        }
        return null;
    }
}

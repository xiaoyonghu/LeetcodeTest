package com.huster.leetcode.lc2024;

import java.util.Stack;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/4 22:37
 * @Desc 有效的括号 栈
 */
public class LC020 {
    public static void main(String[] args) {
//        String s = "()[]{}";
        String s = "(]";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        // 使用一个栈匹配就行
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char indexChar = s.charAt(i);
            if (indexChar == '(' || indexChar == '{' || indexChar == '[') {
                charStack.push(indexChar);
            } else if (indexChar == ')') {
                if (charStack.isEmpty()) {
                    return false;
                }
                Character pop = charStack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (indexChar == '}') {
                if (charStack.isEmpty()) {
                    return false;
                }
                Character pop = charStack.pop();
                if (pop != '{') {
                    return false;
                }
            } else if (indexChar == ']') {
                if (charStack.isEmpty()) {
                    return false;
                }
                Character pop = charStack.pop();
                if (pop != '[') {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}

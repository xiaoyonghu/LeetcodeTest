package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/4/9
 * Description:有效的括号 leetcode 第20题
 * Status:finished
 */
public class Exam20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArrayList<Boolean> a = new ArrayList<>(10);
        while (sc.hasNext()) {
            String s = sc.next();
//            System.out.println(s);
            System.out.println(N_Number(s));
            //a.add(IsValid(s));

        }
//        for (Boolean b : a) {
//            System.out.println(b);
//        }
        //System.out.println(IsValid("(]"));
    }

    public static boolean IsValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //此时为左括号
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 华为面试改版的题目
     * 计数（小意思）
     */
    public static int N_Number(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                if (c == '(')
                    stack1.push(c);
                if (c == '[')
                    stack2.push(c);
            } else {
                if (c == ')') {
                    if (stack1.size() > 0) {
                        char top1 = stack1.pop();//-1操作
                    } else {
                        count++;
                    }
                }
                if (c == ']') {
                    if (stack2.size() > 0) {
                        char top2 = stack2.pop();//-1操作
                    } else {
                        count++;
                    }
                }
            }
        }
        //还有剩下的元素
        if (stack1.size() > 0)
            count += stack1.size();
        if (stack2.size() > 0)
            count += stack2.size();
        return count;
    }
}




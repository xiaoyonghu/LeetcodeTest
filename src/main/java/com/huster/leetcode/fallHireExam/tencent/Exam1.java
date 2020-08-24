package com.huster.leetcode.fallHireExam.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/8/23
 * Description:差多少个括号
 * Status:finished
 */
public class Exam1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum = 0;
        String s = sc.nextLine();
        //System.out.println(s);
        System.out.println(counts(s,sum));
    }

    private static int counts(String s,int res) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //入队操作
            if (c == '('){
                stack1.push(c);
            }
            if(c == '['){
                stack2.push(c);
            }
            //出队操作
            if (c==')'){
                if (stack1.isEmpty()){
                    res++;
                }else {
                    stack1.pop();
                }
            }
            if (c==']'){
                if (stack2.isEmpty()){
                    res++;
                }else {
                    stack2.pop();
                }
            }
        }
        //加上剩下的
        if (!stack1.isEmpty())
            res+=stack1.size();
        if (!stack2.isEmpty())
            res+=stack2.size();
        return res;
    }
}

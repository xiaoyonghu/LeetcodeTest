package com.huster.leetcode.fallHireExam.xiaoMi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/9/15
 * Description:To Do
 * Status:new
 */
public class xiaoMi {
    private static boolean areYouOk(String s) {
        Stack<Character> stack1 = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //入队操作
            if (c == '(') {
                stack1.push(c);
            }
            if (c == '[') {
                stack1.push(c);
            }
            if (c == '{') {
                stack1.push(c);
            }
            //出队操作
            if (c == ')') {
                if (stack1.isEmpty()){
                    return false;
                }else {
                    char cc = stack1.pop();
                    if (cc != '('){
                        return false;
                    }
                }
            }
            if (c == ']') {
                if (stack1.isEmpty()){
                    return false;
                }else {
                    char cc = stack1.pop();
                    if (cc != '['){
                        return false;
                    }
                }
            }
            if (c == '}') {
                if (stack1.isEmpty()){
                    return false;
                }else {
                    char cc = stack1.pop();
                    if (cc != '{'){
                        return false;
                    }
                }
            }
        }
        //加上剩下的
        if (!stack1.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Boolean> list = new ArrayList<>();
        for (; sc.hasNextLine(); ) {
            String ss = sc.nextLine();
            list.add(areYouOk(ss));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

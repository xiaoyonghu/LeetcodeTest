package com.huster.leetcode.kuaishou;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/4/12
 * Description:To Do
 * Status:new
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String math=sc.next();
        System.out.println(getNumber(math));
    }
    public static String getNumber(String s){
        int ok=0, left=0, right=0;
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c =='('){
               stack.push(c);
            }else if (c==')'){
                if (stack.size()>0){
                    char a=stack.pop();
                    ok++;
                }else {
                    right++; //说明左括号已经没了
                }
            }else {
                continue;
            }
        }
        if (stack.size()>0){
            left += stack.size(); //还剩下多少
        }
        return ok+" "+left+" "+right;
    }
}

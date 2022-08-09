package com.huster.leetcode.SwordToOffer.PartitionOne;

import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2019/8/19
 * Description:To Do
 * Thought:在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因
 * 此当遍历到一个空格时，需要在尾部填充两个任意字符
 * Status:new
 */
public class Test5 {
    // Thought 1:最优的方案
    public String replaceSpcace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ')
                //此处加2个空格
                str.append("  ");
        }
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            //看符号的位置 ++i(先加后用) i--(先用后减)
            char c = str.charAt(P1--);
            //从后向前，所以是逆序  规则：%20
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        StringBuffer stringBuffer = new StringBuffer("we are happy.");
        StringBuffer stringBuffer1 = new StringBuffer(" ");
        StringBuffer stringBuffer2 = new StringBuffer(" we");
        StringBuffer stringBuffer3 = new StringBuffer(" we  ");
        String s = test5.replaceSpcace(stringBuffer3);
        System.out.println(s);
    }

    //用栈来实现
    // 问题：不知道栈可以设置多大
//    public String replaceSpace(String s) {
//        int P1 = s.length() - 1;
//        Stack<Character> stack = new Stack<>();
//        for (int i = P1; i >= 0; i--) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                stack.push('0');
//                stack.push('2');
//                stack.push('%');
//            } else {
//                stack.push(c);
//            }
//        }
//        StringBuffer sb = new StringBuffer();
//        if (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.toString();
//    }

    //使用最优的思路（比较经典的思路）
//    public String replaceSpace(String s) {
//        int P1 = s.length() - 1;
//        StringBuffer sBuffer = new StringBuffer();
//        int count = 0;
//        for (int i = 0; i <= P1; i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                count++;
//            }
//            sBuffer.append(c);
//        }
//        for (int j = 1; j <= count; j++) {
//            sBuffer.append(' ');
//            sBuffer.append(' ');
//        }
//
//        int P2 = sBuffer.length() - 1;
//        while (P1 >= 0 && P2 > P1) {
//            char c1 = sBuffer.charAt(P1--);
//            if (c1 == ' ') {
//                sBuffer.setCharAt(P2--, '0');
//                sBuffer.setCharAt(P2--, '2');
//                sBuffer.setCharAt(P2--, '%');
//            } else {
//                sBuffer.setCharAt(P2--, c1);
//            }
//        }
//        return sBuffer.toString();
//    }

    //使用StringBuilder
//    public String replaceSpace(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i <= s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    //使用StringBuilder
//    public String replaceSpace(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i <= s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    //使用String原生函数
    //原生函数就是吊
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

}

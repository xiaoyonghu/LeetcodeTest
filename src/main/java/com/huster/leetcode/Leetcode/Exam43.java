package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/13
 * Description:lc 43 字符串相乘
 * 这个题目难搞哦
 * 我得思维还是不行，太磨叽了,采用递归式的算法
 * Status:finished
 */
public class Exam43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                //本来就在的数  此时该加上的数
                int sum = res[i + j + 1] + n1 * n2;
                //更新留在原地的数
                res[i + j + 1] = sum % 10;
                //进位到前面的数
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}

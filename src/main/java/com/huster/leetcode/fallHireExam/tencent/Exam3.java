package com.huster.leetcode.fallHireExam.tencent;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/23
 * Description:分配问题 肯定是有公式的   n * (2 ^ (n - 1))
 *    https://www.cnblogs.com/zxhl/p/5078443.html
 * Status:finished
 */
public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = (int) (n * Math.pow(2,n-1));
        System.out.println(res);
    }
}

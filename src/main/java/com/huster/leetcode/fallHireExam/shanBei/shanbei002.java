package com.huster.leetcode.fallHireExam.shanBei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/7
 * Description: 找最长的子串
 * Status:finished
 */
public class shanbei002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = i;
            while (j < i && k < n && s.charAt(j) == s.charAt(k)) {
                j++;
                k++;
            }
            if (j == i) {
                max = i > max ? i : max;
            }
        }
        if (max >0 ){
            System.out.println(n - max +1);
        }else {
            System.out.println(n);
        }
    }
}

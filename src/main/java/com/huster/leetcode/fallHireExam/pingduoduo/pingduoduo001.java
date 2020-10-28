package com.huster.leetcode.fallHireExam.pingduoduo;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/23
 * Description:帮何海明做的  拼多多
 * <p>
 * Status:finished
 */
public class pingduoduo001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input < min) {
                min = input;
            }
            if (input > max) {
                max = input;
            }
        }
        int gap = max - min;
        if (gap < m) {
            int left = max - m;
            int right = min + m;
            System.out.print(left + " ");
            System.out.print(right);
        } else if (gap == m) {
            System.out.print(min + " ");
            System.out.print(max);
        } else {
            int left = max - m;
            int right = min + m;
            if (left <= right) {
                System.out.print(left + " ");
                System.out.print(right);
            } else {
                System.out.println("-1");
            }
        }
    }
}

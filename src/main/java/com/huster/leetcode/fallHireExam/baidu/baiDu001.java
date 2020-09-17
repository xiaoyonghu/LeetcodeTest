package com.huster.leetcode.fallHireExam.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/14
 * Description:To Do
 * Status:new
 */
public class baiDu001 {
    public static int[] getXiFenNumber(int[] a, int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] res = new int[a.length];
        int less = 0;
        for (int i = 0; i < a.length; i++) {
            int aa = a[i];
            boolean flag = true;
            for (int j = less; j < b.length; j++) {
                if (aa <= b[j]) {
                    if (flag){
                        less = j - 1;
                        flag =false;
                    }
                    res[i] = res[i] + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] show = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int[] arr1 = new int[num1];
            int[] arr2 = new int[num2];
            for (int j = 0; j < num1; j++) {
                arr1[j] = sc.nextInt();
            }
            sc.nextLine();
            for (int k = 0; k < num2; k++) {
                arr2[k] = sc.nextInt();
            }
            sc.nextLine();
            int[] xiFenNumber = getXiFenNumber(arr1, arr2);
            show[i] = xiFenNumber;
        }

        for (int i = 0; i < n; i++) {
            int[] haha = show[i];
            for (int j = 0; j < n; j++) {
                if (j == haha.length - 1) {
                    System.out.println(haha[j]);
                } else {
                    System.out.print(haha[j] + " ");
                }
            }
        }
    }
}

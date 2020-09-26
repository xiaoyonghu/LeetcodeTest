package com.huster.leetcode.fallHireExam.meiTuan;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description:被翻转的矩阵
 * Status:new  91%
 */
public class meiTuan001 {
    public static int[][] getMin(int[][] arr, int n, int m) {
        int line = 0;
        int[] firstLine = arr[0];
        for (int i = 1; i < n; i++) {
            int[] ok = arr[i];
            if (isMatch(firstLine, ok, m)) {
                line = i;
                break;
            }
        }

        if (line == 0) {
            return arr;
        }
        int[][] res = new int[line / 2 + 1][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = arr[i][j];
            }
        }
        return res;
    }

    private static boolean isMatch(int[] firstLine, int[] ok, int m) {
        for (int i = 0; i < m; i++) {
            if (firstLine[i] != ok[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int[][] haha = getMin(arr, n, m);
        for (int i = 0; i < haha.length; i++) {
            for (int j = 0; j < m; j++) {
                if (j != m - 1) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}

package com.huster.leetcode.fallHireExam.yuewen;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/21
 * Description : 2个矩阵相乘
 * Status:new
 */
public class yuewen004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //mmp这里没用,,分割 ，劳资吐了
        String df = sc.nextLine();
        String[] df1 = df.split(",");

        int m = Integer.parseInt(df1[0]);
        int p = Integer.parseInt(df1[1]);
        int n = Integer.parseInt(df1[2]);
        //sc.nextLine();

        int[][] arr1 = new int[m][p];
        int[][] arr2 = new int[p][n];
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[p];
            String s = sc.nextLine();
            String[] ss = s.split(",");
            for (int j = 0; j < p; j++) {
                tmp[j] = Integer.parseInt(ss[j]);
            }
            for (int j = 0; j < p; j++) {
                arr1[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < p; i++) {
            int[] tmp = new int[n];
            String s = sc.nextLine();
            String[] ss = s.split(",");
            for (int j = 0; j < n; j++) {
                tmp[j] = Integer.parseInt(ss[j]);
            }
            for (int j = 0; j < n; j++) {
                arr2[i][j] = tmp[j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    res[i][j] = res[i][j] + arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) {
                    System.out.print(res[i][j] + ",");
                } else {
                    System.out.println(res[i][j]);
                }
            }
        }
    }
}

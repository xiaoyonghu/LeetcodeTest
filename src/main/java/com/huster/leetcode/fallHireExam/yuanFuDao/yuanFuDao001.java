package com.huster.leetcode.fallHireExam.yuanFuDao;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description:To Do
 * Status:new
 */
public class yuanFuDao001 {
    public static int[] showM(int[] arr, int n, int m) {

        int[] left = new int[n / 2];
        int[] right = new int[n / 2];
        int[] tmp = new int[n];

        if (n <= 0 || m < 0)
            return tmp;
        if (m < 0)
            return tmp;

        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < n / 2; i++) {
                left[i] = tmp[i];
            }
            for (int i = (n / 2); i < n; i++) {
                right[i - (n / 2)] = tmp[i];
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    tmp[i] = right[i / 2];
                } else {
                    tmp[i] = left[(i - 1) / 2];
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res;
        res = showM(arr, n, m);
        for (int i = 0; i < n; i++) {
            if (i != (n - 1)) {
                System.out.print(res[i] + " ");
            } else {
                System.out.print(res[i]);
            }
        }
    }
}

package com.huster.leetcode.fallHireExam.meiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description:To Do
 * Status:new
 */
public class meiTuan005 {
    public static int[] showStatus(int[][] plan, int n) {
        Arrays.sort(plan, (a, b) -> a[2] == b[2] ? b[1] - a[1] : b[2] - a[2]);
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = plan[i][0];
        }
        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            sc.nextLine();
        }
        int[] res = showStatus(arr, n);
        for (int i = 0; i < n; i++) {
            if (i != (n - 1)) {
                System.out.print((res[i] + 1) + " ");
            } else {
                System.out.print((res[i] + 1));
            }

        }
    }
}

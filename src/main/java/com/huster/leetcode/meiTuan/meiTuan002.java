package com.huster.leetcode.meiTuan;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description:To Do
 * Status:new
 */
public class meiTuan002 {
    static int count = 0;

    public static int getTotal(int n, int target, int[] arr, int m) {
        int start = 0;
        int end = 0;
        while (end < n) {
            if (end < n) {
                if (arr[end] < target) {
                    int len = (end - start);
                    if (len >= m) {
                        count += (len - m + 1);
                    }
                    start = end + 1;
                }
            }
            if (end == (n - 1)) {
                int length = end - start + 1;
                if (length >= m) {
                    count += (length - m + 1);
                }
            }
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = getTotal(n, k, arr, m);
        System.out.println(res);
    }

}

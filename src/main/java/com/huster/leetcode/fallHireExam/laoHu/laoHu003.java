package com.huster.leetcode.fallHireExam.laoHu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/20
 * Description:
 * Status:new
 */
public class laoHu003 {
    static int[] getSorted(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 1; i < len - 1; i = i + 2) {
            swap(arr, i, i + 1);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        getSorted(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

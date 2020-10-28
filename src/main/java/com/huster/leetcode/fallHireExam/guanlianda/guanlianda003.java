package com.huster.leetcode.fallHireExam.guanlianda;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/14
 * Description:To Do
 * Status:new
 */
public class guanlianda003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = n - 1; j > i - 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    flag = true;
                    swap(arr, j, j - 1);
                }
            }

            if (flag) {
                count++;
            }
            else {
                break;
            }
        }
        System.out.println(count);
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

}

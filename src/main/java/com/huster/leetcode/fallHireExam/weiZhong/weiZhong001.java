package com.huster.leetcode.fallHireExam.weiZhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/27
 * Description:ac 100%
 * Status:finished
 */
public class weiZhong001 {
    public static int getf1(int[] arr, int target, int n) {
        int index = Arrays.binarySearch(arr, target);
        int res;
        if (index == (-1)){
            return arr[0];
        }
        if (index >= 0 && index < n) {
            res = arr[index];
        } else if (Math.abs(index) > n) {
            res = arr[n - 1];
        } else {
            int realIndex = Math.abs(index) - 1;
            int s1 = arr[realIndex - 1];
            int s2 = arr[realIndex];
            if (Math.abs(s1 - target) <= Math.abs(s2 - target)) {
                res = s1;
            } else {
                res = s2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            System.out.println(getf1(arr,sc.nextInt(),n));
        }

    }
}

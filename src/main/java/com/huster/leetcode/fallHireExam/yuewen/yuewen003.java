package com.huster.leetcode.fallHireExam.yuewen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/21
 * Description:To Do
 * Status:new
 */
public class yuewen003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] arr= new String[n][4];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] ss = s.split(",");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = ss[j];
            }
        }
//        Arrays.sort(arr,(a, b) -> a[1].equals(b[1]) ? a[1].compareTo(b[1]) : a[3].compareTo(b[3]));
//        Arrays.sort(arr,(a, b) -> a[3].equals(b[3]) ? a[3].compareTo(b[3]) : a[2].compareTo(b[2]));
//        Arrays.sort(arr,(a, b) -> a[2].equals(b[2]) ? a[2].compareTo(b[2]) : a[0].compareTo(b[0]));
        Arrays.sort(arr,(a, b) -> (!a[1].equals(b[1])) ? a[1].compareTo(b[1]) : (!a[3].equals(b[3])) ? a[3].compareTo(b[3]) : (!a[2].equals(b[2])) ? a[2].compareTo(b[2]) : a[0].compareTo(b[0]));
            for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0]);
        }
    }
}

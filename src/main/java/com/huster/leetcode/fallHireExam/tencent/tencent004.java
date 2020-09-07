package com.huster.leetcode.fallHireExam.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/6
 * Description:To Do
 * Status:new
 */
public class tencent004 {
    public static List<Integer> getDel(int[] arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 0) {
            return null;
        }
        int[] ss =new int[n];
        for (int i = 0; i < n; i++) {
            ss[i] = arr[i];
        }
        Arrays.sort(ss);
        int mid = n / 2;
        int midValue = ss[mid];
        int preValue = ss[mid-1];

        for (int i = 0; i < n; i++) {
            if (arr[i] < midValue) {
                res.add(midValue);
            } else {
                res.add(preValue);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] ints1 = new int[n];
        for (int i = 0; i < n; i++) {
            ints1[i] = Integer.parseInt(s1[i]);
        }
        List<Integer> arrayList;
        arrayList= getDel(ints1,n);
        for (int i = 0; i < n; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

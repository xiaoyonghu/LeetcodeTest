package com.huster.leetcode.fallHireExam.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/6
 * Description:To Do
 * Status:new
 */
public class tencent001 {
    public static List<Integer> getCommonSub(int[] s, int[] arr) {
        int len1 = s.length;
        int len2 = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (len1 == 0 || len2 == 0) {
            return null;
        }
        int cur1 = 0, cur2 = 0;
        while (cur1 < len1 && cur2 < len2) {
            if (s[cur1] == arr[cur2]) {
                res.add(s[cur1]);
                cur1++;
                cur2++;
            } else if (s[cur1] < arr[cur2]) {
                cur2++;
            } else {
                cur1++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] ints1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            ints1[i] = Integer.parseInt(s1[i]);
        }

        int n2 = sc.nextInt();
        sc.nextLine();
        String ss = sc.nextLine();
        String[] s2 = ss.split(" ");
        int[] ints2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            ints2[i] = Integer.parseInt(s2[i]);
        }
        List<Integer> arrayList;
        arrayList = getCommonSub(ints1, ints2);
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size()) {
                System.out.print(arrayList.get(i) + " ");
            }
        }
    }
}

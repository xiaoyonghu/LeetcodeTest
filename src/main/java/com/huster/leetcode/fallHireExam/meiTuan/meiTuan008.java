package com.huster.leetcode.fallHireExam.meiTuan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/20
 * Description:
 * aabddc
 * abc
 * Status:unfinished
 */
public class meiTuan008 {
    static int count = 0;

    public static boolean isOk(String a, String b) {

        //HashMap<Character, Integer> listB = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = a.length();
        int m = b.length();
        int j = 0;
        for (int i = 0; i < m && j < n; i++, j++) {
            while (j < n && a.charAt(j) != b.charAt(i)) {
                j++;
            }
            arrayList.add(j + 1);
            count++;
        }
        if (count != m) {
            System.out.println("No");
        } else {

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (isOk(s1, s2)) {
            System.out.println("Yes");
            System.out.println(count);
        } else {
            System.out.println("No");
        }
    }
}

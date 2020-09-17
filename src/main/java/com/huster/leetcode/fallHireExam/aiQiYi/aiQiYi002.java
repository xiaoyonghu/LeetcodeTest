package com.huster.leetcode.fallHireExam.aiQiYi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description:To Do
 * Status:new
 */
public class aiQiYi002 {
    public static int getNumber(int[] arr, int n) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        for (int ker : hashMap.keySet()) {
            if (hashMap.get(ker) > (n / 2)) {
                res = ker;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] chars = s.split(" ");
        int n = chars.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(chars[i]);
        }
        System.out.println(getNumber(arr, n));


    }
}

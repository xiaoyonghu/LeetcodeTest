package com.huster.leetcode.fallHireExam.souGou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/5
 * Description:需要使用Double
 * Status:finished
 */
public class souGou002 {
    public static int getHosueCount(int[] arr, int target) {
        int sum = 2;
        Double[][] center = new Double[arr.length / 2][2];
        for (int i = 0; i < arr.length; ) {
            center[i / 2][0] = Double.valueOf(arr[i]);
            center[i / 2][1] = Double.valueOf(arr[i + 1]);
            i += 2;
        }

        //排序
        Arrays.sort(center, Comparator.comparingDouble(o -> o[0]));

        Double left, right;
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            Double centerPoint1 = center[i][0];
            Double point1Width1 = center[i][1];
            Double centerPoint2 = center[i + 1][0];
            Double point1Width2 = center[i + 1][1];
            right = centerPoint1 + point1Width1 / 2.0;
            left = centerPoint2 - point1Width2 / 2.0;
            if (left - right > target) {
                sum += 2;
            } else if ((right - left) == target) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.charAt(0) - '0';

        int last = s.lastIndexOf(']');
        String s1 = s.substring(3, last);
        String[] strings = s1.split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            System.out.println(arr[i]);
        }
        System.out.println(getHosueCount(arr, n));
    }
}

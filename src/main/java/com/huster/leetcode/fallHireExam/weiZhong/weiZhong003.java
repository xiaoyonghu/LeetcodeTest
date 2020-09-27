package com.huster.leetcode.fallHireExam.weiZhong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/27
 * Description: 回溯 64%
 * Status:unfinished
 */
public class weiZhong003 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if (n <= 0) {
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //ArrayList<Integer> index = new ArrayList<>();
        int[] pre = new int[2];
        backTrack(arr, 0, pre);
        System.out.println(count);
    }

    private static void backTrack(int[] arr, int step, ArrayList<Integer> track) {
        if (track.size() == 3) {
            count++;
            return;
        }

        for (int i = step; i < arr.length; i++) {
            if (track.isEmpty() || (track.get(track.size() - 1) <= arr[i])) {
                track.add(arr[i]);
                backTrack(arr, i + 1, track);
                track.remove(track.size() - 1);
            }
        }
    }

    private static void backTrack(int[] arr, int step, int[] pre) {
        if (pre[0] == 3) {
            count++;
            return;
        }

        for (int i = step; i < arr.length; i++) { //用了step了
            if (pre[0] == 0 || (pre[1] <= arr[i])) {
                int tmp = pre[1];
                pre[1] = arr[i];
                pre[0] += 1;

                backTrack(arr, i + 1, pre);

                pre[0] -= 1;
                pre[1] = tmp;
            }
        }
    }

}

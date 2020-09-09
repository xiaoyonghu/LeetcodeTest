package com.huster.leetcode.fallHireExam.shanBei;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/7
 * Description:涂颜色
 * Status:unfinished
 */
public class shanbei003 {
    static int count = 0;

    public static int getTotalColor(int[][] arr, int start, int n, int m) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(arr, track, 0, n, m);
        return count;
    }

    private static void backTrack(int[][] arr, LinkedList<Integer> track, int start, int n, int m) {
        if (track.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < m; i++) {
            int pre;
            if (track.size() == 0) {
                track.add(i);
                backTrack(arr, track, start + 1, n, m);
                track.removeLast();
            } else {
                pre = track.get(track.size() - 1);
                if (isValid(arr, i, pre)) {
                    track.add(i);
                    backTrack(arr, track, start + 1, n, m);
                    track.removeLast();
                }
            }
        }
    }
    private static boolean isValid(int[][] arr, int i, int pre) {
        int[] tmp = arr[pre];
        for (int j = 0; j < tmp.length; j++) {
            if (tmp[j] == i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nCount; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            int[][] arr = new int[m][k];
            for (int a = 0; a < m; a++) {
                for (int j = 0; j < k; j++) {
                    arr[a][j] = (sc.nextInt() - 1);
                }
                sc.nextLine();
            }
            System.out.println(getTotalColor(arr, 0, n, m));
        }
    }
}

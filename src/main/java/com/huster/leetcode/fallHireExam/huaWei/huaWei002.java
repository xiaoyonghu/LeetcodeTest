package com.huster.leetcode.fallHireExam.huaWei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/9
 * Description: 最长的水沟
 * Status:unfinished
 */
public class huaWei002 {
    static int maxLen = 1;
    static int count = 1;
    static int[][] direction = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    //时间复杂度 m*m*n*n
    public static int getMaxDitchLength(int[][] arr, int n, int m) {
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(arr, i, j, visited, n, m);
            }
        }
        return maxLen;
    }

    private static void dfs(int[][] arr, int i, int j, int[][] visited, int n, int m) {
//        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] == 1)
//            return;

        /**
         * 看着感觉和递归的常规逻辑不同
         */
        for (int k = 0; k < 4; k++) {
            //下一层的坐标
            int row = i + direction[k][0];
            int col = j + direction[k][1];
            if (isValid(row, col, n, m)) {
                //地势相等不能流动
                if (visited[row][col] != 1 && arr[row][col] < arr[i][j]){
                    visited[i][j] = 1;
                    count++;
                    if (count > maxLen) {
                        maxLen = count;
                    }
                    dfs(arr, row, col, visited, n, m);

                    count--;
                    visited[i][j] = 0;
                }
            }
        }
        return;
//        //上
//        if ((i - 1) >= 0 && (visited[i - 1][j] != 1) && arr[i - 1][j] < arr[i][j]) {
//            visited[i][j] = 1;
//            count++;
//            if (count > maxLen) {
//                maxLen = count;
//            }
//            dfs(arr, i - 1, j, visited, n, m);
//            count--;
//            visited[i][j] = 0;
//        }
//        //下
//        if ((i + 1) < n && (visited[i + 1][j] != 1) && arr[i + 1][j] < arr[i][j]) {
//            visited[i][j] = 1;
//            count++;
//            if (count > maxLen) {
//                maxLen = count;
//            }
//            dfs(arr, i + 1, j, visited, n, m);
//            count--;
//            visited[i][j] = 0;
//        }
//        //左
//        if ((j - 1) >= 0 && (visited[i][j - 1] != 1) && arr[i][j - 1] < arr[i][j]) {
//            visited[i][j] = 1;
//            count++;
//            if (count > maxLen) {
//                maxLen = count;
//            }
//            dfs(arr, i, j - 1, visited, n, m);
//            count--;
//            visited[i][j] = 0;
//        }
//        //右
//        if ((j + 1) < m && (visited[i][j + 1] != 1) && arr[i][j + 1] < arr[i][j]) {
//            visited[i][j] = 1;
//            count++;
//            if (count > maxLen) {
//                maxLen = count;
//            }
//            dfs(arr, i, j + 1, visited, n, m);
//            count--;
//            visited[i][j] = 0;
//        }

    }

    private static boolean isValid(int row, int col, int n, int m) {
        if (row >= 0 && row < n && col >= 0 && col < m)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(getMaxDitchLength(arr, n, m));
    }
}

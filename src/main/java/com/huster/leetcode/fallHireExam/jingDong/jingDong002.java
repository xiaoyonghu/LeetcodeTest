package com.huster.leetcode.fallHireExam.jingDong;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/17
 * Description: wtf真的蛋疼  当时脑袋一片空白，真是蛋疼
 * Status:finished
 */
public class jingDong002 {
    static int[][] direction = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};
    public static boolean getOK(char[][] arr, int fromX, int fromY, int targetX, int targetY) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] visited = new int[n][m];
        if (dfs(arr, fromX, fromY, visited, targetX, targetY, n, m)) {
            return true;
        }
        return false;
    }

    private static boolean isValid(int row, int col, int n, int m) {
        if (row >= 0 && row < n && col >= 0 && col < m)
            return true;
        return false;
    }
    private static boolean dfs(char[][] arr, int i, int j, int[][] visited, int targetX, int targetY, int n, int m) {
        if ((i == targetX) && (j ==targetY)){
            return true;
        }
        for (int k = 0; k < 4; k++) {
            //下一层的坐标
            int row = i + direction[k][0];
            int col = j + direction[k][1];
            if (isValid(row, col, n, m)) {
                if (visited[row][col] != 1 && arr[row][col] != '#'){
                    visited[i][j] = 1;
                    if (dfs(arr, row, col, visited,targetX,targetY, n, m)){
                        return true;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        return false;

//        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] == 1)
//            return false;
//
//        if (i == targetX && j == targetY) {
//            return true;
//        }
//
//
//        //上
//        if ((i - 1) >= 0 && (visited[i - 1][j] != 1) && (arr[i - 1][j] != '#')) {
//            visited[i][j] = 1;
//
//            if (dfs(arr, i - 1, j, visited, targetX, targetY, n, m)) {
//                return true;
//            }
//            visited[i][j] = 0;
//        }
//        //下
//        if ((i + 1) < n && (visited[i + 1][j] != 1) && (arr[i + 1][j] != '#')) {
//            visited[i][j] = 1;
//
//            if (dfs(arr, i + 1, j, visited, targetX, targetY, n, m)) {
//                return true;
//            }
//            visited[i][j] = 0;
//        }
//        //左
//        if ((j - 1) >= 0 && (visited[i][j - 1] != 1) && (arr[i][j - 1] != '#')) {
//            visited[i][j] = 1;
//            if (dfs(arr, i, j - 1, visited, targetX, targetY, n, m)) {
//                return true;
//            }
//            visited[i][j] = 0;
//        }
//        //右
//        if ((j + 1) < m && (visited[i][j + 1] != 1) && (arr[i][j + 1] != '#')) {
//            visited[i][j] = 1;
//            if (dfs(arr, i, j + 1, visited, targetX, targetY, n, m)) {
//                return true;
//            }
//            visited[i][j] = 0;
//        }
//        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        boolean[] res = new boolean[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            char[][] arr = new char[a][b];
            int fromX, fromY, toX, toY;
            fromX = 0;
            fromY = 0;
            toX = 0;
            toY = 0;

            for (int k = 0; k < a; k++) {
                String s = sc.nextLine();
                for (int l = 0; l < b; l++) {
                    char c = s.charAt(l);
                    if (c == 'E') { //公主
                        toX = k;
                        toY = l;
                    }
                    if (c == 'S') {  //王子
                        fromX = k;
                        fromY = l;
                    }
                    arr[k][l] = s.charAt(l);
                }
            }
            res[j++] = getOK(arr, fromX, fromY, toX, toY);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}

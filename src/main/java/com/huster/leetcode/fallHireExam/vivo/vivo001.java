package com.huster.leetcode.fallHireExam.vivo;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description:vivo 最优路径
 * Status:unfinished
 */
public class vivo001 {
    static int count = 1;
    static int minLen = Integer.MAX_VALUE;
    static int[][] direction = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    public static int getLenOfRoad(char[][] chars, int n, int fromX, int fromY, int toX, int toY, int[][] visited) {
        if (chars[fromX][fromY] == '#' || chars[fromX][fromY] == '@' || chars[toX][toY] == '#' || chars[toX][toY] == '@')
            return -1;
        backTrack(chars, n, fromX, fromY, toX, toY, visited);
        return minLen;
    }

    private static void backTrack(char[][] chars, int n, int fromX, int fromY, int toX, int toY, int[][] visited) {

        if ((fromX == toX) && (fromY == toY)) {
            minLen = Math.min(minLen, count);
            return;
        }
        for (int k = 0; k < 4; k++) {
            //下一层的坐标
            int row = fromX + direction[k][0];
            int col = fromY + direction[k][1];
            if (isValid(row, col, n)) {
                if ((visited[row][col] != 1) && (chars[row][col] != '#') && (chars[row][col] != '@')) {
                    visited[fromX][fromY] = 1;
                    count++;
                    backTrack(chars, n, row, col, toX, toY, visited);
                    count--;
                    visited[fromX][fromY] = 0;
                }
            }
        }
    }

    private static boolean isValid(int row, int col, int n) {
        if (row >= 0 && row < n && col >= 0 && col < n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int fromX = sc.nextInt();
        int fromY = sc.nextInt();
        int toX = sc.nextInt();
        int toY = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int[][] visited = new int[n][n];
        int res = getLenOfRoad(arr, n, fromX, fromY, toX, toY, visited);
        System.out.println(res);
    }
}

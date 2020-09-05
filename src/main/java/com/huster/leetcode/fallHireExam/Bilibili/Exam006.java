package com.huster.leetcode.fallHireExam.Bilibili;

/**
 * @author Created by Divo
 * @date 2020/9/4
 * Description:sword to offer 原题
 * Status:unfinished
 */
public class Exam006 {
    public int[] SpiralMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int r = matrix.length, col = matrix[0].length;
        int[] res = new int[r * col];
        int index = 0;
        int left = 0, right = col - 1, top = 0, bot = r - 1;
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            for (int j = top + 1; j <= bot; j++) {
                res[index++] = matrix[j][right];
            }
            if (left < right && top < bot) {
                for (int i = right - 1; i > left; i--) {
                    res[index++] = matrix[bot][i];
                }
                for (int i = bot; i > top; i--) {
                    res[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bot--;
        }
        return res;
    }
}

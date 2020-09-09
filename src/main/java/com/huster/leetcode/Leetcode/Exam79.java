package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/9/8
 * Description:lc 79 单词搜索
 * Thought：可以参考212 hard难度的
 * Status:finished
 */
public class Exam79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        //int start = 0;
        int len = word.length();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backTrack(board, row, col, i, j, 0, len, visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int row, int col, int i, int j, int start, int len, int[][] visited, String word) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] == 1) {
            return false;
        }
        if (start >= len)
            return false;
        if (start == (len - 1))
            return board[i][j] == word.charAt(start);


        if (word.charAt(start) == board[i][j]) {
            //只有相等的时候才改状态
            visited[i][j] = 1;
            //上下左右
            if (backTrack(board, row, col, i - 1, j, start + 1, len, visited, word)
                    || backTrack(board, row, col, i + 1, j, start + 1, len, visited, word)
                    || backTrack(board, row, col, i, j - 1, start + 1, len, visited, word)
                    || backTrack(board, row, col, i, j + 1, start + 1, len, visited, word))
                return true;
            visited[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        Exam79 exam79 = new Exam79();
        String s = "SEE";
        long startTime = System.currentTimeMillis();
        System.out.println(exam79.exist(board,s));
        long endTime =System.currentTimeMillis();
        System.out.println("运行时间为"+ (endTime-startTime));
    }
}

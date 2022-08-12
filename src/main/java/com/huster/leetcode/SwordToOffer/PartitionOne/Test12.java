package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2022/8/11
 * Description:矩阵中的路径
 * Thought:DFS + 回溯
 * 个人感觉算比较有意思的题了（复习了一下）
 * Status:new
 */
public class Test12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, visited, 0)) return true;
            }

        }
        return false;
    }

    //case 1
    private boolean dfs(char[][] board, char[] words, int i, int j, boolean[][] visited, int wStart) {
        //回溯的结束条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || words[wStart] != board[i][j]) return false;
        if (wStart == words.length - 1) return true;

        //在剩下的列表做选择
        visited[i][j] = true;
        boolean res;
        res = dfs(board, words, i + 1, j, visited, wStart + 1)
                || dfs(board, words, i - 1, j, visited, wStart + 1)
                || dfs(board, words, i, j + 1, visited, wStart + 1)
                || dfs(board, words, i, j - 1, visited, wStart + 1);

        //撤销选择
        visited[i][j] = false;
        return res;
    }


    //case 2 不用耗费额外的空间 visited，直接改当前的数组board[i][j]


    public static void main(String[] args) {
    }
}

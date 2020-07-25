package com.huster.leetcode.Leetcode;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by Divo
 * @date 2020/7/23
 * Description:岛屿问题 --->可以与朋友圈的问题进行对照
 * Status:finished
 * Thought：
 * 1、暴力
 * 2、DFS BFS
 * 3、并查集
 */
public class Exam200 {
    // 1、DFS
    int row, col, count;

    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0)
            return 0;
        col = grid[0].length;
        count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    //消除周围所有的
                    _dfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    public void _dfs(char[][] grid, int i, int j) {
        //1、结束条件
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1')
            return;
        //2、 处理当前的值
        grid[i][j] = '0';

        //3、drill down
        _dfs(grid, i + 1, j);//下
        _dfs(grid, i - 1, j);//上
        _dfs(grid, i, j - 1);//左
        _dfs(grid, i, j + 1);//右

        //4、reverse current states if needed
    }

    //2、BFS
    //时间复杂度为 m*n
    //空间复杂度为m*n + queue
    int m, n, countBfs;
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int numIslands1(char[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;
        countBfs = 0;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> bfsQue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfsQue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    _bfs(grid, bfsQue, visited);
                    ++countBfs;
                }
            }
        }
        return countBfs;
    }

    public void _bfs(char[][] grid, LinkedList<int[]> bfsQue, boolean[][] visited) {
        //1、判断queue
        while (!bfsQue.isEmpty()) {
            //2 取出最前面的节点
            int[] cur = bfsQue.poll();

            //3、process current node

            //4、generated_nodes
            for (int dir[] : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && (grid[x][y] == '1') && !visited[x][y]) {
                    //5、把相关的节点放入queue里面
                    bfsQue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        Exam200 exam200 = new Exam200();
        System.out.println(exam200.numIslands1(grid));
    }
}

package com.huster.leetcode.Leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/7/20
 * Description:n皇后问题
 * Status:
 * 1、有py的12行代码打印全部
 * 2、下面的这种办法是统计有多少种解法
 */
public class Exam51 {
    static int count = 0;

    //这种思路我很欣赏
    //统计n皇后有多少种解法
    public void queenCount(int n, int row, int col, int pie, int na) {
        //终止条件
        if (row >= n) {
            count++;
            //return;
        } else {
            //得到现在可用的列 其中1可用列，0表示没有（注意这里已经倒转过来了）
            int pos = (~(col | pie | na)) & ((1 << n) - 1);
            //枚举所有1的位置，然后去放置皇后
            while (pos != 0) {
                //取出pos的二进制最后一个1所在位置的值
                int p = pos & (-pos);
                //col | p 将p二进制位1的位置上放皇后
                //(pie | p) << 1 更新pie的下一层不能放的位置，是因为由pie造成的占位在下一行要左移一下；
                //(na | p) << 1 更新na的下一层不能放的位置
                queenCount(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
                //去掉最低位的1
                //pos = pos ^ p;
                pos = pos & (pos - 1);
            }
        }
    }

    //正规的回溯算法
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board, res, 0);
        return res;
    }

    private void backTrack(char[][] board, List<List<String>> res, int row) {
        if (row == board.length) {
            res.add(construct(board));
            count++;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(board, res, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int N = board.length;

        //检查前面所有行
        for (int i = 0; i < row; i++) {
            //当前列
            if (board[i][col] == 'Q')
                return false;

            int rowDiff = row - i;
            // 45度
            if (col + rowDiff < N && board[i][col + rowDiff] == 'Q')
                return false;
            //135度
            if (col - rowDiff >= 0 && board[i][col - rowDiff] == 'Q')
                return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            arrayList.add(new String(board[i]));
        }
        return arrayList;
    }


    public static void main(String[] args) {
        Exam51 queen = new Exam51();
        //queen.queenCount(8, 0, 0, 0, 0);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<String>> show = queen.solveNQueens(n);
        System.out.println(n + ":皇后,共有" + count + "解法");

        List<String> list;
        for (int i = 0; i < show.size(); i++) {
            list = show.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
            System.out.println("-------------------------->");
        }
    }
}

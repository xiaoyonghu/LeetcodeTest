package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2019/8/19
 * Description:二维数组中的查找
 * Thought:该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边(可以从左下角和右上角开始)
 * Status:new
 * <p>
 * 时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数
 */
public class Test4 {
//    public boolean find(int target, int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return false;
//        int rows = matrix.length, cols = matrix[0].length;
//        int r = 0, c = cols - 1;//从右上角开始
//        while (r <= rows - 1 && c >= 0) {
//            if (target == matrix[r][c])
//                return true;
//                //如果目标大于选择的数，去除所在的行（即就行行数加一）
//            else if (target > matrix[r][c])
//                r++;
//                //去除所在的列
//            else
//                c--;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[][] data1 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //boolean b = test4.find(20, data1);
        boolean b = test4.findNumberIn2DArray(data1, 20);
        System.out.println(b);

    }

    //如果一边不行，那就从另外一边来考虑该问题
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target == matrix[row][col]) {
                return true;
            } else {
                col--;
            }
        }
        return false;
    }
}

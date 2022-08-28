package com.huster.leetcode.Leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/7/22
 * Description：Exam94 120  三角形最小路径和
 * Status:finished
 */
public class Exam120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        //定义状态变量,这里让dp的初始值为triangle的最后一行
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                //状态转移方程
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {
        List<List<Integer>> triangleTest = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        Exam120 exam = new Exam120();
        System.out.println(exam.minimumTotal(triangleTest));
    }
}


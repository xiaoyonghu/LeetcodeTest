package com.huster.leetcode.Leetcode;

import java.util.ArrayList;

/**
 * @author Created by Divo
 * @date 2020/8/22
 * Description:lc 679 24点游戏
 * 采用回溯思路，但是比回溯模板难
 * Status:finished
 */
public class Exam679 {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;  //不是L的小写 而是数字1
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return backTrack(list);
    }

    private boolean backTrack(ArrayList<Double> list) {
        //1 判断结束条件
        if (list.size() == 0)
            return false;

        if (list.size() == 1)
            return Math.abs(list.get(0) - TARGET) < EPSILON;

        //2 在所有的列表进性选择
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    ArrayList<Double> list1 = new ArrayList<>();
                    //将剩下的数字放入准备的列表
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            list1.add(list.get(k));
                        }
                    }
                    //取操作符   做选择
                    for (int k = 0; k < 4; k++) {
                        // + * 不用管位置
                        if (k < 2 && i > j)
                            continue;
                        if (k == ADD) {
                            list1.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list1.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list1.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (list.get(j) < EPSILON) {  //为0
                                continue;
                            } else {
                                list1.add(list.get(i) / list.get(j));
                            }
                        }
                        //3 递归到下一层
                        if (backTrack(list1))
                            return true;
                        //4 恢复状态
                        list1.remove(list1.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}

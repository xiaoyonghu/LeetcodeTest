package com.huster.leetcode.fallHireExam.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:40中颜色中找6种不同颜色的组合
 * Status:new
 */
public class tencent006 {
    static int count = 0;
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int arrayLength = 40;
        int subLength = 6;
        int array[] = new int[arrayLength + 1];
        for (int i = 1; i <= arrayLength; i++) {
            array[i] = i;
        }
        List<Integer> track = new ArrayList<>();
        backTrack(array, track, arrayLength, subLength, 1);
    }

    private static void backTrack(int[] array, List<Integer> track, int arrayLength, int subLength, int curIndex) {
        if (track.size() == subLength) {
            res.add(new ArrayList<>(track));
            count++;
            return;
        }

        //这里i=curIndex 的话可以直接去重，也就是直接从后面往前面看
        for (int i = curIndex; i <= arrayLength; i++) {
            track.add(array[i]);
            backTrack(array, track, arrayLength, subLength, i + 1);
            track.remove(track.size() - 1);
        }
    }
}

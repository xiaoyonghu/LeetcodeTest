package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/8
 * Description:lc 46 全排列
 * Status:finished
 */
public class Exam46 {
    /**
     * 回溯解法  时间复杂度高
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        int[] visited = new int[nums.length];
        backtrack(nums, track, visited);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int[] visited) {
        //结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        //选择列表
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            visited[i] = 1;
            //做选择
            track.add(nums[i]);
            //进入下一层
            backtrack(nums, track, visited);
            //撤销选择
            track.removeLast();
            visited[i] = 0;
        }
    }
}

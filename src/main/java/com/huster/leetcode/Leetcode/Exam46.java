package com.huster.leetcode.Leetcode;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/8/8
 * Description:lc 46 全排列
 * Thought:也可以参见lc官方给的例子，直接交换元素来实现
 * 这里采用使用visited
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

        HashMap<Integer, Integer> map = new HashMap<>();
        map.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
        map.containsKey("");
        StringBuilder sb = new StringBuilder();
        sb.toString();

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int[] visited) {
        //结束条件
        if (track.size() == visited.length) {
            res.add(new LinkedList<>(track));
        }

        //可选项
        for (int i = 0; i < visited.length; i++) {
            //做选择
            if (visited[i] == 0) {
                //更改状态
                visited[i] = 1;
                track.add(nums[i]);

                //递归到下一层
                backtrack(nums, track, visited);

                //恢复状态
                track.removeLast();
                visited[i] = 0;
            }
        }
    }

}

package com.huster.leetcode.Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Divo
 * @date 2020/8/31
 * Description:lc 841 钥匙和房间
 * Status:new
 */
public class Exam841 {

    boolean[] visited;
    int num;

    //解法一：DFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    //熟悉模板
    private void dfs(List<List<Integer>> rooms, int i) {
        visited[i] = true;
        num++;//处理了一间未处理的房间
        //处理下一层
        for (int x : rooms.get(i)) {
            if (!visited[x]) {
                dfs(rooms, x);
            }
        }
    }

    //BFS模板，需要熟悉
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            //弹出
            int cur = queue.poll();
            //处理当前节点
            num++;
            //处理后序节点
            for (int x : rooms.get(cur)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.offer(x);
                }
            }
        }
        return num == n;
    }
}

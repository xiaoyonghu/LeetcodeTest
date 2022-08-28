package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description: Exam94 207 课程表
 * Thought：邻接表表示法  BFS,DFS
 * Status:finished
 */
public class Exam207 {
    //BFS
    //时间复杂度为O(N*M)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //比较巧妙的应用了下标
        int[] indegress = new int[numCourses]; //用来统计入度
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        //Get the indegree and adjacency of every course.
        for (int[] p : prerequisites) {
            indegress[p[0]]++;// 0所对应的是后续节点
            adjacency.get(p[1]).add(p[0]);//1对应前去节点
        }

        //把所有入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0)
                queue.add(i);
        }

        //BFS
        //1、判断while
        //时间复杂度为O(N*M) N为节点数 M为边数
        while (!queue.isEmpty()) {
            //2、出队
            int pre = queue.poll();

            //3、process current node
            numCourses--;

            //4、generated node
            for (int next : adjacency.get(pre)) {
                if ((--indegress[next]) == 0)
                    //5、把相关的节点放入queue里面
                    queue.add(next);
            }
        }
        return numCourses == 0;
    }

    //DFS
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];//默认初始化值为0
        for (int[] p : prerequisites) {
            adjacency.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        //1、终止条件
        if (flags[i] == -1) return true;
        if (flags[i] == 1) return false;
        //2、处理当前节点
        flags[i] = 1;  //本轮访问的节点标记的状态值
        //3、递归到下一层
        for (int p : adjacency.get(i))
            if (!dfs(adjacency, flags, p)) return false;
        //4、恢复当前节点的状态
        flags[i] = -1;  //结束以i节点的本轮的访问
        return true;
    }
}

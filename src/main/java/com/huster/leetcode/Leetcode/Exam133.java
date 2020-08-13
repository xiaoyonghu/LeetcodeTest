package com.huster.leetcode.Leetcode;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/8/12
 * Description:lc 133 克隆图
 * DFS/BFS
 * Status:finished
 */
public class Exam133 {
    //内部类
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //采用BFS来做比较好
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        HashMap<Node, Node> visited = new HashMap<>();
        //BFS必备之队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                //跟新当前节点的邻居列表
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

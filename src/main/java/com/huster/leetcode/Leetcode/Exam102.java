package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 102 二叉树的层次遍历
 * Status:finished
 */
public class Exam102 {
    //BFS模板
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }

    //DFS模板
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode cur, List<List<Integer>> res, int level) {
        if (res.size() - 1 < level)
            res.add(new ArrayList<>());
        res.get(level).add(cur.val);
        if (cur.left != null) dfs(cur.left, res, level + 1);
        if (cur.right != null) dfs(cur.right, res, level + 1);
    }

}

package com.huster.leetcode.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 20:07
 * @Desc 二叉树工具类
 */
public class TreeUtil {
    // 根据层次遍历序列构建二叉树
    public static TreeNode createBinaryTree(List<Integer> levelOrder) {
        if (levelOrder == null || levelOrder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.size()) {
            TreeNode currentNode = queue.poll();

            if (levelOrder.get(i) != null) {
                currentNode.left = new TreeNode(levelOrder.get(i));
                queue.offer(currentNode.left);
            }
            i++;

            if (i < levelOrder.size() && levelOrder.get(i) != null) {
                currentNode.right = new TreeNode(levelOrder.get(i));
                queue.offer(currentNode.right);
            }
            i++;
        }
        return root;
    }
}

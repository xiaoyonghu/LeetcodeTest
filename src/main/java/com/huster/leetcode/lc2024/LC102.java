package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/15 20:21
 * @Desc 二叉树的层次遍历  总结出模板
 */
public class LC102 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC102 lc102 = new LC102();
        lc102.levelOrder(root).forEach(x ->{
            for (int i = 0; i < x.size(); i++) {
                System.out.print(x.get(i) + ", ");
            }
            System.out.println();
        });
    }

    // 层次遍历 BFS来做
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int levelSize = 0;
        // 树层次遍历模板
        while (!queue.isEmpty()){
            levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            resList.add(list);
        }
        return resList;
    }
}

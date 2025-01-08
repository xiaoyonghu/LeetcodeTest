package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 22:36
 * @Desc 翻转二叉树
 */
public class LC226 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 7, 1, 3, 6, 9);
        TreeNode root = TreeUtil.createBinaryTree(list);
        invertTree(root);
        System.out.println(111);
    }

    public static TreeNode invertTree(TreeNode root) {
        // 后序遍历
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }
}

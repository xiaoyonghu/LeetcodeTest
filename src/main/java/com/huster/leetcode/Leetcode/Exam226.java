package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 226 翻转二叉树
 * Status:new
 */
public class Exam226 {
    public TreeNode invertTree(TreeNode root) {
        //采用先序遍历的方式
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        //采用先序遍历的方式
        if (root == null)
            return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}

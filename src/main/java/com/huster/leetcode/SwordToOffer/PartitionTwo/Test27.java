package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * @Author yongshao
 * @create 2022/9/13 23:25
 * Description:  好久不刷树相关的题目了，太菜了
 */
public class Test27 {

//    //dfs  由下而上
//    public TreeNode mirrorTree(TreeNode root) {
//
//        if (root == null) return null;
//        TreeNode tp = root.left;
//        root.left = mirrorTree(root.right);
//        root.right = mirrorTree(tp);
//
//        return root;
//    }

    //从上换到下(先序遍历)
//    public TreeNode mirrorTree(TreeNode root) {
//
//        if (root == null) return null;
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//
//        return root;
//    }

    //使用栈来实现 从上而下
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t.left != null) stack.add(t.left);
            if (t.right != null) stack.add(t.right);
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

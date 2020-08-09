package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/8/8
 * Description:lc 99 恢复二叉搜索树
 * 1、中序遍历 + 数组（找出逆序） + 中序遍历交换
 * 2、中序遍历（a.递归的过程中找出交换  b.使用迭代的中序遍历）
 * Status:finished
 */
public class Exam99 {

    // 迭代中序
//    public void recoverTree(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode p = root;
//        TreeNode x = null, y = null, pre = null;
//        while (p != null || !stack.isEmpty()) {
//            while (p != null) {
//                stack.push(p);
//                p = p.left;
//            }
//            p = stack.pop();
//            //处理当前节点
//            if (pre != null && p.val < pre.val) {
//                y = p;
//                if (x == null) {
//                    x = pre;
//                } else {
//                    break;
//                }
//            }
//            pre = p;
//            p = p.right;
//        }
//        swap(x, y);
//    }
//    private void swap(TreeNode x, TreeNode y) {
//        int temp = x.val;
//        x.val = y.val;
//        y.val = temp;
//    }


    /**
     * 递归 中序
     */
    TreeNode x = null, y = null, pre = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        swap(x, y);
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (pre != null && root.val < pre.val) {
            x = x == null ? pre : x;
            y = root;
        }
        pre = root;
        traverse(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}

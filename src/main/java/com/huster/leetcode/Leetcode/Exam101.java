package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:Exam94 101 对称的二叉树
 * Status:finished
 */
public class Exam101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (q== null && p==null)
            return true;
        if (q== null || p==null)
            return  false;
        if (q.val != p.val)
            return false;
        return isSymmetric(p.left,q.right)&& isSymmetric(p.right,q.left);
    }
}

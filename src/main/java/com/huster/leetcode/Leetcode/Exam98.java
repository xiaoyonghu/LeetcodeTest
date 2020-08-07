package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:Exam94 98 验证二叉搜索树
 * Status:finished
 */
public class Exam98 {
    /**
     * 1、应用他的特性，中序遍历得到的节点必定升序
     * 2、应用递归
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
                        //      root为左边的最大值              root为右子树的最小值
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}

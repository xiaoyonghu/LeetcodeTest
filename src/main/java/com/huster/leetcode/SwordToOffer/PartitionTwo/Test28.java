package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Yongshao
 * @Date 2022/10/9
 * Description:判断一个二叉树是否对称；与27题，二叉树的镜像类似
 * 新思路：左和右（多刷题即可，小意思）
 */
public class Test28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        // 比较通用写法
        // 都为空
        if (left == null && right == null) return true;
        // 有一个为空，一个不为空 || 2个对称节点的值不相等
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}

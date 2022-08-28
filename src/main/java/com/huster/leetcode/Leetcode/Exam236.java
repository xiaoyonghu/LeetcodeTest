package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 236 二叉树的最近公共祖先
 * Status:finished
 */
public class Exam236 {
    /**
     * 1、先序遍历，用一个队列记录下途中访问的节点，然后对2个数组进行取最近公共节点
     * 2、递归（思想比较巧妙）
     * //主整体的思想就是判断他到底在不在
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左边不存在，那么就是右节点；如果右边不存在，那么就是左节点；
        // 如果左右都存在，那就是根节点
        //return left == null ? right : right == null ? left : root;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

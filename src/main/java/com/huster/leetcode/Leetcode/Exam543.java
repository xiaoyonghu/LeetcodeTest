package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 543 二叉树的直径
 * Status:finished
 */
public class Exam543 {
    int maxRes;

    public int diameterOfBinaryTree(TreeNode root) {
        dp(root);
        return maxRes;
    }

    //典型的后序遍历
    int dp(TreeNode root) {
        if (root == null)
            return 0;
        int leftDep = dp(root.left);
        int rightDep = dp(root.right);
        maxRes = Math.max(leftDep + rightDep, maxRes);//最大路径包含改root节点
        return Math.max(leftDep, rightDep) + 1;  //最大路径不包含该root节点，只是参与回溯
    }
}

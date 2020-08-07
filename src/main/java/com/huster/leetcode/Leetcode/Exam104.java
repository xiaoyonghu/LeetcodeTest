package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 104 二叉树的最大深度
 * Status:finished
 */
public class Exam104 {
    //典型的后序遍历问题
    public int maxDepth(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

//    private int getMaxDepth(TreeNode cur) {
//        if (cur == null)
//            return 0;
//        return Math.max(getMaxDepth(cur.left),getMaxDepth(cur.right)) + 1;
//    }
}

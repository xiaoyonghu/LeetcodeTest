package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 114 二叉树展开为一个单链表
 * Status:finished
 *      讨论区的变形后序迭代方式没看懂
 */
public class Exam114 {
    /**
     * 后序遍历的变形版本
     *
     * @param root
     */
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);//先访问右边
        flatten(root.left);//再访问左边

        root.right = pre;
        root.left = null;
        pre = root;
    }
}

package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 20:05
 * @Desc 二叉树的最大深度
 *
 * 1、使用二叉树的递归
 * 2、使用二叉树的BFS的层次遍历来解决 TODO
 */
public class LC104 {
    public static void main(String[] args) {
        // root = [3,9,20,null,null,15,7]
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeUtil.createBinaryTree(list);
        System.out.println(maxDepth(root));
    }

    /**
     * 使用二叉树的递归来解决
     **/
    public static int maxDepth(TreeNode root) {
        // 后续遍历
        if (root == null) return 0;
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return 1 + Math.max(leftLength, rightLength);
    }
}

package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/10 21:18
 * @Desc 对称二叉树
 */
public class LC101 {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
        List<Integer> list = Arrays.asList(1, 2, 2, null, 3, null, 3);
        TreeNode root = TreeUtil.createBinaryTree(list);
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        return subSymmetric(root.left, root.right);
    }

    // 2棵树的问题(得熟悉)
    private static boolean subSymmetric(TreeNode left, TreeNode right) {
        // 使用先序遍历
        if (left == null && right == null) return true;

        // 使用简写
//        if (left == null || right ==null) return false;
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;

        if (left.val != right.val) return false;
        return subSymmetric(left.left, right.right)
                && subSymmetric(left.right, right.left);

    }


}

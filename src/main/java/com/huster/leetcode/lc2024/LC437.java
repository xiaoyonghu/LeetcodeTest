package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/6 22:36
 * @Desc 路径总和 III
 */
public class LC437 {
    public static void main(String[] args) {
        List<Integer> list = Arrays
                .asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC437 lc437 = new LC437();
        int k = 8;
        int result = lc437.pathSum(root, k);
        System.out.println(result);
    }

    public int pathSum(TreeNode root, int targetSum) {
        // 回溯 ？
        //
        return 0;
    }
}

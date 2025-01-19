package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/19 17:26
 * @Desc 将有序数组转换为二叉搜索树
 * 有序的数是二叉搜索树的中序
 * 规则：转换为一棵 "平衡" 二叉搜索树。
 */
public class LC108 {
    public static void main(String[] args) {
//        int[] nums = {-10, -3, 0, 5, 9};
        int[] nums = {0,1,2,3,4,5};
        LC108 lc108 = new LC108();
        TreeNode root = lc108.sortedArrayToBST(nums);

        System.out.println(111);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // 二分法的体现？
        // 构建根节点、构建左子树、构建右子树
        int len = nums.length;

        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, 0, mid - 1);
        root.right = buildTree(nums, mid + 1, len - 1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // 要么都构建右子树、要么都构建左子树？(不行)
        int mid = (left + right) / 2;
        if (left > right) return null;
        TreeNode node = new TreeNode(nums[mid]);
        // 全部构建左子树
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);
        return node;
    }
}

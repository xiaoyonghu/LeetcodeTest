package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/23 20:49
 * @Desc 二叉树展开为链表
 * TODO：更多高级解法看题解
 */
public class LC114 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 3, 4, null, 6);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC114 lc114 = new LC114();
        lc114.flatten(root);
        //1、暴力方法：先先序遍历，存到list后续进行构建

    }

    // 暴力解法：简单可行！！
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        flattenDFS(root, list);
        TreeNode cur = root;
        // 重新构建
        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
    }

    private void flattenDFS(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left!=null) flattenDFS(root.left, list);
        if (root.right!=null) flattenDFS(root.right, list);
    }


}

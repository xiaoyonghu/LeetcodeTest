package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/19 18:45
 * @Desc 二叉搜索树中的第K小的元素
 */
public class LC230 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 4, null, 2);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC230 lc230 = new LC230();
//        System.out.println(lc230.kthSmallestDFS(root, 2));
        System.out.println(lc230.kthSmallest(root, 2));
    }

    // 二叉树的中序遍历 递归和非递归版本
    // 递归版本 + 额外的数组
    public int kthSmallestDFS(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        // 使用数组传递
        KthDFSOne(root, list);
        if (list.size() >= k){
            return list.get(k-1);
        }
        return 0;
    }

    // 二叉树中序非递归
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            k--;
            if (k == 0) {
                return p.val;
            }
            p = p.right;
        }
        return 0;
    }

    // 使用数组
    private void KthDFSOne(TreeNode root, List<Integer> list) {
        if(root == null) return;
        KthDFSOne(root.left,list);
        list.add(root.val);
        KthDFSOne(root.right,list);
    }


}

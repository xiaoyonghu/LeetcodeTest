package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 105 前序、中序 构造二叉树
 * Status:finished
 */
public class Exam105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> index = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return  buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1, index);
    }

    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer, Integer> index) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = index.get(root.val);
        int numLeft = inRoot - inStart;  //[inStart,inRoot)
        root.left = buildTree(preOrder, preStart + 1, preStart + numLeft,
                inOrder, inStart, inRoot - 1, index);
        root.right = buildTree(preOrder, preStart + numLeft + 1, preEnd,
                inOrder, inRoot + 1, inEnd, index);
        return root;
    }
}

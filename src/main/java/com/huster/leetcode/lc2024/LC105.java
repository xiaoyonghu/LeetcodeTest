package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/11 21:18
 * @Desc 从前序和中序遍历序列构造二叉树
 * 这种题解记住就行了(自己会推理即可)
 */
public class LC105 {

    HashMap<Integer, Integer> orderMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}; // 先序遍历
        int[] inorder = {9, 3, 15, 20, 7};  // 中序遍历
        //先序 3  9  20  15  7
        //中序 9  3  15  20  7
        LC105 lc105 = new LC105();
        TreeNode root = lc105.buildTree(preorder, inorder);
        System.out.println(1111);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 找出中间的节点，然后构建左子树，然后构建右子树
        int totalLen = preorder.length;
        int preIndex = 0;
        int rootVal = preorder[preIndex];

        // 是否使用map来存储k,v
        for (int i = 0; i < inorder.length; i++) {
            orderMap.putIfAbsent(inorder[i], i);
        }
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == rootVal) inIndex = i;
//        }
        int inIndex = orderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // x-(preIndex+1) + 1 = inIndex
        root.left = buildTree(preorder, preIndex + 1, preIndex + inIndex, inorder, 0, inIndex - 1);
        root.right = buildTree(preorder, preIndex + inIndex + 1, totalLen, inorder, inIndex + 1, totalLen - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        //          preL         preR
        //先序 3  9  20     15    7
        //中序 9  3  15     20    7
        //          inL    inI   inR
        //1、写结束条件（递归结束条件）
        if (preLeft > preRight || inLeft > inRight) return null;
        int tempVal = preorder[preLeft];

//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == tempVal) inIndex = i;
//        }
        int inIndex = orderMap.get(tempVal);
        TreeNode node = new TreeNode(tempVal);
        // 推理过程
        // x -(preLeft+1) + 1 = inI-1 -inL + 1
        // x - preLeft = inIndex -inLeft
        // x = inIndex - inLeft + preLeft
        node.left = buildTree(preorder, preLeft + 1, inIndex - inLeft + preLeft, inorder, inLeft, inIndex - 1);
        node.right = buildTree(preorder, inIndex - inLeft + preLeft + 1, preRight, inorder, inIndex + 1, inRight);
        return node;
    }
}

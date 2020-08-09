package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Created by Divo
 * @date 2020/8/8
 * Description:lc 297 二叉树的序列化与反序列化
 * 1、前序递归
 * 2、层次遍历
 * Status:finished
 */
public class Exam297 {
    private static final String spliter = ",";
    private static final String NN = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * 先序遍历
         */
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode cur, StringBuilder sb) {
        if (cur == null)
            sb.append(NN).append(spliter);
        else {
            sb.append(cur.val).append(spliter);
            serialize(cur.left,sb);
            serialize(cur.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(spliter);
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(split));
        return rDeserialize(strings);
    }

    private TreeNode rDeserialize(LinkedList<String> list) {
        /**
         * 先序反序列化
         */
        if (list.get(0).equals(NN)) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }

}

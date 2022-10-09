package com.huster.leetcode.SwordToOffer.PartitionThree;

import com.huster.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yongshao
 * @Date 2022/10/9
 * Description:从上到下打印二叉树
 * 基础的BFS
 */
public class Test32_1 {

    Deque<TreeNode> queue;
    Deque<Integer> queue2;

    int[] res;

    public int[] levelOrder(TreeNode root) {
        //注意初始的节点
        if(root == null) return new int[0];
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollFirst();
            queue2.addLast(temp.val);
            if (temp.left != null) queue.addLast(temp.left);
            if (temp.right != null) queue.addLast(temp.right);
        }

        int count = queue2.size();
        res = new int[count];

        for (int i = 0; i < count; i++) {
            res[i] = queue2.pollFirst();
        }
        return res;
    }
}

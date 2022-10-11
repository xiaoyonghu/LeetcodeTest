package com.huster.leetcode.SwordToOffer.PartitionThree;

import com.huster.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @Author yongshao
 * @create 2022/10/9 22:35
 * Description: 和 32_2类似（第一行从左到右，第二行从右到左，第三行从左到右）
 *
 */
public class Test32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        int rev = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
//                if (rev % 2 != 0) {
//                    //先右节点，再左节点
//                    if (node.right != null) queue.addLast(node.right);
//                    if (node.left != null) queue.addLast(node.left);
//                } else {
//                    //先左节点，再右节点
//                    if (node.left != null) queue.addLast(node.left);
//                    if (node.right != null) queue.addLast(node.right);
//                }
                //先右节点，再左节点
                if (node.right != null) queue.addLast(node.right);
                if (node.left != null) queue.addLast(node.left);
            }
            if (rev % 2 != 0){
                reverseList(temp);
            }
            res.add(temp);
        }
        return res;
    }

    private void reverseList(List<Integer> temp) {
        Collections.reverse(temp);
    }
}

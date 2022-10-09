package com.huster.leetcode.SwordToOffer.PartitionThree;

import com.huster.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yongshao
 * @Date 2022/10/9
 * Description:从上到下打印二叉树 II
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?favorite=xb9nqhhg
 */
public class Test32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //卧槽，不是那个的话，还需要自己实现抽象方法
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            //这个写法对分层问题比较给力
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}

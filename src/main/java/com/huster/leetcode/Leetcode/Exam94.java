package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 94 二叉树的中序遍历
 * Status:finished
 */
public class Exam94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    /**
     * 二叉树遍历的模板方法
     * @param root
     * @param list
     */
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root!= null){
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }

    /**
     * 采用栈的方式
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur !=null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                //把此节点的左边左边节点都放进去
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            //此时该加入节点的右节点了
            cur = cur.right;
        }
        return list;
    }
}

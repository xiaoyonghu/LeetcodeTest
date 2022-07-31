package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 235 二叉搜索树的最近公共祖先  另外的一种是二叉树
 * Status:finished
 */
public class Exam235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //利用了二叉搜索树的特性

        if (root.val < p.val && root.val < q.val) { //在右边
            lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) { //在右边
            lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //利用了二叉搜索树的特性
        while (root!=null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }

}

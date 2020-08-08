package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 100 相同的树  为了刷8月份的每日一题而刷
 * Status:finished
 */
public class Exam100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //前序遍历
        if (p == null && q==null)
            return true;
        if (p ==null || q==null)
            return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 124 二叉树中的最大路径和
 * Status:finished
 */
public class Exam124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return result;
    }

    /**
     * 典型的二叉树后序遍历
     * @param cur
     * @return
     */
    private int getMax(TreeNode cur) {
        if (cur == null) return 0;

        //如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0,getMax(cur.left));
        int right = Math.max(0,getMax(cur.right));

        //左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
        result = Math.max(left+right+cur.val,result);

        //其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        return Math.max(left,right)+cur.val;
    }
}

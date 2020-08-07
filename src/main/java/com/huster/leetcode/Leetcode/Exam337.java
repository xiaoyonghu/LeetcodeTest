package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/8/5
 * Description:Exam94 337 打家劫舍III 传说中的最高智商的犯罪？？
 * Status:finished
 */
public class Exam337 {

    /**
     * 1、采用递归（从上往下）加记忆（Hashmap）
     * 2、从下往上的递归
     * @param root
     * @return
     */
    //递归
    //时间复杂度为O(N) 每个节点遍历一次
    public int rob(TreeNode root) {
        int[] res=dp(root);
        robSub(root,new HashMap<>());
        return Math.max(res[0],res[1]);
    }

    /**
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     * @param root
     * @return
     */
    private int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0,0};//不写默认也是0
        int[] left = dp(root.left);
        int[] right =dp(root.right);

        //抢当前节点,左和右就都不能抢
        int rob=root.val + left[0] + right[0];

        //不抢当前节点，左右可抢可不抢
        int notRob= Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{notRob,rob};
    }


    public int robSub(TreeNode root, HashMap map){
        if (root == null)
            return 0;
        //记忆法
        if (map.containsKey(root))
            return (int) map.get(root);

        //抢当前的node
        int rob = root.val +
                (root.left == null? 0:robSub(root.left.left,map)+robSub(root.left.right,map))
                + (root.right == null? 0: robSub(root.right.left,map)+robSub(root.right.right,map));

        //不抢当前的node
        int notRob = robSub(root.left,map)+robSub(root.right,map);

        int res = Math.max(rob,notRob);
        map.put(root,res);
        return res;
    }
}

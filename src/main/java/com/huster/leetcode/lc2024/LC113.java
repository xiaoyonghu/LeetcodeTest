package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/7 20:48
 * @Desc 路径总和II
 * 与 lc112 相比是找路径，需要记录所有从根节点到叶子节点路径和为target的
 */
public class LC113 {

    // 优先定义到外面
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays
                .asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC113 lc113 = new LC113();
        int target = 22;
        List<List<Integer>> lists = lc113.pathSum(root, target);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> x = lists.get(i);
//            for (int j = 0; j < x.size(); j++) {
//                System.out.print(x);
//            }
            System.out.println(x);
//            System.out.println();
        }
    }

    // 这个很像是回溯的题
    // 层次遍历BFS解决不了该问题（可以解决，但是需要一个前缀指针，每个节点指向其父亲节点即可）
    // 使用递归来解决 使用递归的先序遍历
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 使用递归的先序遍历
        int sum = 0;
        pathSumDFS(root, targetSum, sum);
        return resList;
    }

    public void pathSumDFS(TreeNode root, int targetSum, int sum) {
        if (root == null) return;

        // below code is just for testing
        System.out.println("cur val " + root.val);
//        System.out.println("sum val " + sum);
//        System.out.println("total sum : " + (sum + root.val));
//        System.out.println();

        tempList.add(root.val);
        if (root.left == null && root.right == null && (sum + root.val) == targetSum) {
            // 拷贝tempList中的元素去新数组
//            List<Integer> res = new ArrayList<>(tempList.size());
//            for (int i = 0; i < tempList.size(); i++) {
//                res.add(tempList.get(i));
//            }
//            resList.add(res);
            // 优先使用这种解法
            resList.add(new ArrayList(tempList));
        }
        pathSumDFS(root.left, targetSum, sum + root.val);
        pathSumDFS(root.right, targetSum, sum + root.val);

        // 测试最后的一个节点的值，符合预期
        Integer lastVal = tempList.get(tempList.size() - 1);
        System.out.println("last val : "+ lastVal);

        // 需要对tempList里面的元素进行剔除
        tempList.remove(tempList.size() - 1);
    }
}

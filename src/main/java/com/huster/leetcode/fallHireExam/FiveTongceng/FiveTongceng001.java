package com.huster.leetcode.fallHireExam.FiveTongceng;

import java.util.ArrayList;


/**
 * @author Created by Divo
 * @date 2020/10/11
 * Description:数组的前序、中序、后序遍历
 * Status:40%
 * 5.8同城测试
 */
public class FiveTongceng001 {
    public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> preList = new ArrayList<>();
        preScan(input,0,preList);
        result.add(preList);

        ArrayList<Integer> midList = new ArrayList<>();
        midScan(input,0,midList);
        result.add(midList);

        ArrayList<Integer> postList = new ArrayList<>();
        postScan(input,0,postList);
        result.add(postList);

        return result;
    }

    private void preScan(int[] input, int root, ArrayList<Integer> list) {
        if (root > input.length){
            return;
        }

        list.add(input[root]);

        if ((2*root+1)<input.length && (input[2*root+1]!= (-1))){
            preScan(input,2*root+1,list);
        }
        if ((2*root+2)<input.length && (input[2*root+2]!= (-1))){
            preScan(input,2*root+2,list);
        }
    }

    private void midScan(int[] input, int root, ArrayList<Integer> list) {
        if (root > input.length){
            return;
        }

        if ((2*root+1)<input.length && (input[2*root+1]!= (-1))){
            preScan(input,2*root+1,list);
        }

        list.add(input[root]);

        if ((2*root+2)<input.length && (input[2*root+2]!= (-1))){
            preScan(input,2*root+2,list);
        }
    }

    private void postScan(int[] input, int root, ArrayList<Integer> list) {
        if (root > input.length){
            return;
        }

        if ((2*root+1)<input.length && (input[2*root+1]!= (-1))){
            preScan(input,2*root+1,list);
        }

        if ((2*root+2)<input.length && (input[2*root+2]!= (-1))){
            preScan(input,2*root+2,list);
        }

        list.add(input[root]);
    }


}

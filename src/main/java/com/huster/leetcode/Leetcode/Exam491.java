package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Created by Divo
 * @date 2020/8/31
 * Description:lc 491 最长上升子序列
 * Status:new
 */
public class Exam491 {
    List<Integer> temp;
    List<List<Integer>> res;
    HashSet<Integer> set;
    int n;

    //使用的是 Rabin-Karp 编码，只需要记住继就行了
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        temp = new ArrayList<>();
        res = new ArrayList<>();
        set = new HashSet<>();
        if (n == 0) {
            return res;
        }

        //这里是2对的n次方,进行这么多次的操作
        for (int i = 0; i < (1 << n); i++) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) (1E9 + 7));
            if (check() && !set.contains(hashValue)) {
                set.add(hashValue);
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }

    private boolean check() {
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) < temp.get(i - 1))
                return false;
        }
        return temp.size() >= 2;
    }

    private int getHash(int base, int mod) {
        int hashValue = 0;
        //对每个元素都采用hash
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    private void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; i++) {
            //最后一位不是1
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    //解法二：采用递归，看的我吐了
    public List<List<Integer>> findSubsequences1(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private void dfs(int cur, int last, int[] nums) {
        //结束条件
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);//选择当前元素
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);//放弃选择
        }
    }

    public static void main(String[] args) {
    }
}

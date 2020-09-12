package com.huster.leetcode.fallHireExam.RedBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description:To Do
 * Status:new
 */
public class redBook001 {
    static int findMin(int[] tree) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < tree.length; i++) {
            if (max < tree[i]) {
                max = tree[i];

            }
            set.add(tree[i]);
        }

        for (int i = 1; i <= max; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        return max + 1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _tree_size = 0;
        _tree_size = Integer.parseInt(in.nextLine().trim());
        int[] _tree = new int[_tree_size];
        int _tree_item;
        for (int _tree_i = 0; _tree_i < _tree_size; _tree_i++) {
            _tree_item = Integer.parseInt(in.nextLine().trim());
            _tree[_tree_i] = _tree_item;
        }

        res = findMin(_tree);
        System.out.println(String.valueOf(res));

    }
}

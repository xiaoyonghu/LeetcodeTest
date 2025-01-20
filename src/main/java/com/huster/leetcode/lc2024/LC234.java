package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 21:38
 * @Desc 回文链表(向前读和向后读都是一样的)
 */
public class LC234 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 2, 1);
        List<Integer> list = Arrays.asList(1, 2);
        ListNode head = ListUtil.createList(list);
        LC234 lc234 = new LC234();
        System.out.println(lc234.isPalindrome(head));

    }

    // TODO:使用快慢指针
    // 使用最简单的办法：先遍历一遍，然后使用2个指正
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        //使用双指针遍历链表
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) != list.get(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

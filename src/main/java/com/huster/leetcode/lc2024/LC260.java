package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 20:43
 * @Desc 反转链表
 */
public class LC260 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode head = ListUtil.createList(list);
        LC260 lc260 = new LC260();
        ListNode revHead = lc260.reverseList(head);

        while (revHead != null) {
            System.out.println(revHead.val + " -> ");
            revHead = revHead.next;
        }

    }

    //这种写法与题解的类似
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        // 2指针？3指针？
        ListNode tail = null;
        ListNode cur = head;
        ListNode pre = head.next;
        while (pre != null) {
            cur.next = tail;
            tail = cur;
            cur = pre;
            pre = pre.next;
            cur.next = tail;
        }
        return cur;
    }
}

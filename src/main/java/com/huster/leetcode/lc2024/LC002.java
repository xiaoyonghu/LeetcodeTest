package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/22 20:15
 * @Desc 两数相加
 */
public class LC002 {
    public static void main(String[] args) {
//        List<Integer> list1 = Arrays.asList(2, 4, 3);
//        List<Integer> list2 = Arrays.asList(5, 6, 4);

        List<Integer> list1 = Arrays.asList(9, 9, 9, 9, 9, 9, 9);
        List<Integer> list2 = Arrays.asList(9, 9, 9, 9);

        ListNode l1 = ListUtil.createList(list1);
        ListNode l2 = ListUtil.createList(list2);

        LC002 lc002 = new LC002();
        ListNode head = lc002.addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建一个List
        if (l1 == null && l2 == null) return null;

        ListNode head = new ListNode(-1);  // 新建一个头节点
        ListNode cur = head;
        int stepForward = 0; // 进位值
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            int totalSum = stepForward + p1.val + p2.val;
            if (totalSum >= 10) {
                stepForward = totalSum / 10;
            } else {
                stepForward = 0;
            }
            int addValue = totalSum % 10;
            ListNode node = new ListNode(addValue);
            cur.next = node;
            cur = node;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int totalSum = stepForward + p1.val;
            if (totalSum >= 10) {
                stepForward = totalSum / 10;
            }else {
                stepForward = 0;
            }
            int addValue = totalSum % 10;
            ListNode node = new ListNode(addValue);
            cur.next = node;
            cur = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            int totalSum = stepForward + p2.val;
            if (totalSum >= 10) {
                stepForward = totalSum / 10;
            }else {
                stepForward = 0;
            }
            int addValue = totalSum % 10;
            ListNode node = new ListNode(addValue);
            cur.next = node;
            cur = node;
            p2 = p2.next;
        }

        if (stepForward > 0){   // 如果还有值，说明还有进位
            ListNode node = new ListNode(stepForward);
            cur.next = node;
        }

        return head.next;
    }
}

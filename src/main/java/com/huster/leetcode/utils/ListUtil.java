package com.huster.leetcode.utils;

import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 20:44
 * @Desc 链表工具类
 */
public class ListUtil {

    public static ListNode createList(List<Integer> list){
        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return head;
    }
}

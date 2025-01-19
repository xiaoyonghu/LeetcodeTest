package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/19 22:24
 * @Desc 相交链表
 */
public class LC160 {
    public static void main(String[] args) {
        // 这种题目没意思！！！
    }
    // 使用Set和栈都一样
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}

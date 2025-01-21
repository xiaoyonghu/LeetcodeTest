package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 21:39
 * @Desc 环形链表II
 */
public class LC142 {
    public static void main(String[] args) {

    }

    // 这个数学证明还可以
    // a+(n+1)b+nc=2(a+b)⟹ a=c+(n−1)(b+c)
    // a表示起始点到循环开始点的距离
    // b表示循环开始点到相遇点的距离
    // c表示相遇点到循环开始点的距离
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) { // 第一次相遇
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }

    /**
     * 借鉴141的思路 ,OK, Pass
     **/
    public ListNode detectCycleSlow(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}

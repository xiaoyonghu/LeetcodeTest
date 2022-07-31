package com.huster.leetcode.SwordToOffer;

import com.huster.leetcode.utils.ListNode;

/**
 * @author Created by Divo
 * @date 2020/9/4
 * Description:24 翻转链表
 * Status:finished   需要多写
 */
public class sto024 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null,next=null,pNode=head,reversedHeader=null;
        if (head ==null)
            return null;
        while (pNode!=null){
            next = pNode.next;
            if (next == null)
                reversedHeader = pNode;
            pNode.next =pre;
            pre=pNode;
            pNode = next;
        }
        return reversedHeader;
    }
}

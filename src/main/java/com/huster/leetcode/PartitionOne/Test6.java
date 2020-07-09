package com.huster.leetcode.PartitionOne;

import java.util.ArrayList;


/**
 * @author Created by Divo
 * @date 2019/8/21
 * Description: 从尾到头打印链表  剑指Offer第6题
 * Thought: 适合用 （stack recursion 头插法）都可以实现链表的逆序
 * Status:finished
 */
public class Test6 {

    ArrayList<Integer> ret = new ArrayList<>();
    //使用递归来实现
//    public ArrayList<Integer> printListFromTailToHeadUsingRecursion(ListNode listNode ) {
//        if (listNode != null){
//            this.printListFromTailToHeadUsingRecursion(listNode.next);
//            ret.add(listNode.val);
//        }
//        return ret;
//    }

    //使用栈来实现
//    public ArrayList<Integer> printListFromTailToHeadUsingStack(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null){
//           stack.add(listNode.val) ;
//           listNode = listNode.next;
//        }
//        while (!stack.isEmpty()){
//            ret.add(stack.pop());
//        }
//        return ret;
//    }



}

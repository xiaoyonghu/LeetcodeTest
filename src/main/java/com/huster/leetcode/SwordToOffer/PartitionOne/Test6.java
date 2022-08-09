package com.huster.leetcode.SwordToOffer.PartitionOne;

import com.huster.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * @author Created by Divo
 * @date 2019/8/21
 * Description: 从尾到头打印链表  剑指Offer第6题
 * Thought: 适合用 （stack recursion 头插法）都可以实现链表的逆序
 * Status:finished
 */
public class Test6 {

    public static void main(String[] args) {

    }

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

    // 这种逆序，最容易想到的就是使用stack
    // lc上这种解法基本上很打败很少人
    // 时间复杂度O(N)
    // 空间复杂度O(N)
//    public int[] reversePrint(ListNode head) {
//        //ArrayList<Integer> ret = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        int len = 0, j = 0;
//        while (head != null) {
//            stack.push(head.val);
//            //指向下一个节点
//            head = head.next;
//            len++;
//        }
//        int[] res = new int[len];
//        while (!stack.isEmpty()) {
//            res[j++] = stack.pop();
//        }
//        return res;
//    }

    // 直接遍历链表2遍
    // 时间复杂度O(N)
    // 空间复杂度O(1)
    public int[] reversePrint(ListNode head) {
        ListNode mNode;
        int len = 0, i = 0;
        mNode = head;
        while (mNode != null) {
            mNode = mNode.next;
            len++;
        }
        int[] res = new int[len];
        mNode = head;
        for (int j = len - 1; j >= 0; j--) {
            res[j] = mNode.val;
            mNode = mNode.next;
        }
        return res;
    }

}

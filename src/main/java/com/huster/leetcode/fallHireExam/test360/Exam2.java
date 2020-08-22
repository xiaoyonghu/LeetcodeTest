package com.huster.leetcode.fallHireExam.test360;


import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Created by Divo
 * @date 2020/8/22
 * Description: 对数组进行2种操作
 * Status:new
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        //sc.nextLine();
        int[] opArray= new int[m];
        for (int i = 0; i < m; i++) {
            opArray[i] = sc.nextInt();
        }
        Deque<Integer> deque = new LinkedBlockingDeque<>(n);
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < m; i++) {
            if (opArray[i] == 1){
                operationOne(deque);
            }else if(opArray[i] == 2){
                operationTwo(deque,n);
            }
        }
        System.out.println(deque.toString());
    }

    private static void operationOne(Deque<Integer> deque) {
        deque.addLast(deque.removeFirst());
    }

    private static void operationTwo(Deque<Integer> deque,int n) {
        for (int i = 0; i < n/2; i++) {
            int pre,cur;
            pre=deque.removeFirst();
            cur=deque.removeFirst();
            deque.addLast(cur);
            deque.addLast(pre);
        }
    }
}

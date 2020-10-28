package com.huster.leetcode.prepareForOffer.multiThread;


/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description : 线程交替打印  使用volatile来打印
 * Status: finished
 */
public class jiaoTiPrint002 {

    public volatile static boolean flag = true;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println("A" + ":" + Thread.currentThread().getName());
                    flag = false;
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                if (!flag) {
                    System.out.println("B" + ":" + Thread.currentThread().getName());
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.setName("线程B");
        threadB.start();
    }
}

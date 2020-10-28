package com.huster.leetcode.prepareForOffer.multiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description : 线程交替打印奇数和偶数
 * Status:new
 */
public class jiaoTiPrint001 {
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore B = new Semaphore(0);
    //private static Semaphore C = new Semaphore(0);

    public static AtomicInteger count = new AtomicInteger(1);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.println("A" + ":" + Thread.currentThread().getName());
                    count.getAndIncrement();
                    B.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println("B" + ":" + Thread.currentThread().getName());
                    count.getAndIncrement();
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


//    static class ThreadC extends Thread {
//        @Override
//        public void run() {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    C.acquire();
//                    System.out.println("C");
//                    A.release();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setName("线程A");
        threadA.start();


        ThreadB threadB = new ThreadB();
        threadB.setName("线程B");
        threadB.start();
        //new ThreadC().start();
    }
}

package com.huster.leetcode.prepareForOffer.producerAndConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description:中心体
 * Status:finished
 */
public class Container {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition(); //不满
    private final Condition notEmpty = lock.newCondition();  //不空
    private int capacity;
    private List<Integer> list = new LinkedList<>();

    Container(int capacity) {
        this.capacity = capacity;
    }

    public void consume() { //消费者
        lock.lock();
        try {
            while (list.size() == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int val = list.remove(0);
            System.out.println("Consumer :" + Thread.currentThread().getName() + " 消费 :" + val + "  队列大小为 " + list.size());
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void produce(Integer val) {  //生产者
        lock.lock();
        try {
            while (list.size() == capacity) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(val);
            System.out.println("Producer ：" + Thread.currentThread().getName() + "  生产 :" + val + " 队列大小为 " + list.size());
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

package com.huster.leetcode.prepareForOffer.producerAndConsumer;

/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description:把生产者和消费者结合起来
 * Status:finished
 */
public class test {
    public static void main(String[] args) {

        Container container = new Container(10);
        Thread producer1 = new Thread(new Producer(container), "生产者1");
//        Thread producer2 = new Thread(new Producer(container));
//        Thread producer3 = new Thread(new Producer(container));

        Thread consumer1 = new Thread(new Consumer(container), "消费者1");
//        Thread consumer2 = new Thread(new Consumer(container));
//        Thread consumer3 = new Thread(new Consumer(container));
//        Thread consumer4 = new Thread(new Consumer(container));

        producer1.start();
//        producer2.start();
//        producer3.start();

        consumer1.start();
//        consumer2.start();
//        consumer3.start();
//        consumer4.start();
    }
}

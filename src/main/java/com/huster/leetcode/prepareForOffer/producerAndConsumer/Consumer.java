package com.huster.leetcode.prepareForOffer.producerAndConsumer;

/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description:消费者
 * Status:finished
 */
public class Consumer implements Runnable{
    private Container container;
    Consumer(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        while (true){
            container.consume();
        }
    }
}

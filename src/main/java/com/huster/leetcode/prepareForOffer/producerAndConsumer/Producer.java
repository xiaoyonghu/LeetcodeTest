package com.huster.leetcode.prepareForOffer.producerAndConsumer;

import java.util.Random;

/**
 * @author Created by Divo
 * @date 2020/10/26
 * Description:生产者
 * Status:finished
 */
public class Producer implements Runnable {
    private Container container;

    Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            container.produce(new Random().nextInt(100));
        }
    }
}

package com.huster.leetcode.BaiduNewCoderTest;

import java.util.PriorityQueue;

/**
 * @author Created by Divo
 * @date 2020/3/31
 * Description: 数据流中的中位数
 * Status:new
 */
public class test12 {
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->(o2-o1));//最大堆  存左边的
    private PriorityQueue<Integer> right = new PriorityQueue<>((o1,o2)->(o2-o1));//最小堆  存右边的
    int N=0;//用来计数
    int LMax,RMax;
    public void Insert(Integer num) {
        if(N % 2 ==0){ //偶数存到最右边 ，先存最左边，把最大值然后加到最右边
            left.add(num);
             LMax=left.poll();
            right.add(LMax);
        }else {
            right.add(num);
            RMax=right.poll();
            left.add(RMax);
        }
            N++;
    }

    public Double GetMedian() {
        if (N % 2 ==0){
            return (left.poll()+right.poll()) / 2.0;
        }
        else {
            return Double.valueOf(left.poll());
        }

    }
}

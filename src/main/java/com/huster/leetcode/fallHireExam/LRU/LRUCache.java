package com.huster.leetcode.fallHireExam.LRU;

import java.util.LinkedHashMap;

/**
 * @author Created by Divo
 * @date 2020/9/4
 * Description:lc 146 LRU 缓存机制
 * Status:finished
 * see more detail in <href>https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/lru-suan-fa<href/>
 */
public class LRUCache {
    //实例上面是Integer，Integer
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //修改key的值
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        //新的数
        if (cache.size() >= cap) {
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);

    }

    //key一定存在
    public void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

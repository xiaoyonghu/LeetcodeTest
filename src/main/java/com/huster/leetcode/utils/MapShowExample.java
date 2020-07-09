package com.huster.leetcode.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Created by Divo
 * @date 2020/4/9
 * Description:hashmap的添加，遍历方法
 * Status:new
 */
public class MapShowExample {
    HashMap<String,Integer> phone=new HashMap<>(10);

    public void test(String[] arr){
        phone.put("Apple",0);
        phone.put("SAMSUNG",2);
        phone.put("Meizu",3);
        phone.put("Xiaomi",4);

        /**
         * 添加方法
         */
        for (String s:arr){
            if (phone.containsKey(s)){
                phone.put(s,phone.get(s)+1);
            }
            else {
                phone.put(s,1);
            }
        }

        /**
         * 通过keyset来遍历
         */
        for (String key:phone.keySet())
            System.out.println(key+" : "+phone.get(key));

        /**
         * 通过entryset来遍历
         */
        for (Map.Entry<String,Integer> mapping: phone.entrySet()){
            System.out.println(mapping.getKey()+" : "+mapping.getValue());
        }
        /**
         * 通过迭代器来遍历
         */
        Iterator iterator = phone.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" : "+value);
        }


    }
    public static void main(String[] args) {
       String[] s=new String[]{"Apple","dami","Xiaomi"};
        MapShowExample mapTest1=new MapShowExample();
        mapTest1.test(s);
    }

}

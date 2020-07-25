package com.huster.leetcode.utils;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/4/9
 * Description:常用的hashmap排序的用法及
 *                   最大堆，最小堆的简历语法
 * Status:new
 */
public class MapSortExample {
    /**
     * 建立最大堆
     * @param args
     */
    private PriorityQueue<Integer> Max_Dump=new PriorityQueue<>((o1, o2)->(o2-o1));

    /**
     * 建立最小堆
     * @param args
     */
    private PriorityQueue<Integer> Min_Dump=new PriorityQueue<>();


    private HashMap<String,Integer> phone=new HashMap<>(10);
    /**
     * 对hashmap中的元素按照key进行排序
     * 对hashmpa中的元素按照值进行排序
     * @param
     */
    private  void sortHashMap(){
        /**
         * 这里只是暂时的写了一下
         */
        phone.put("Apple",7299);
        phone.put("SAMSUNG",6000);
        phone.put("Meizu",2698);
        phone.put("Xiaomi",2400);

        /**
         * 对key进行排序
         */
        Set set=phone.keySet();
        //得先把set转换为list
        Object[] arr = set.toArray();
        Arrays.sort(arr);
//        for (Object key:arr){
//            System.out.println(key+" : " +phone.get(key));
//        }

        //System.out.println(phone.containsKey("xiaomi"));
//        for (String s:phone.keySet()){
//            System.out.println(s);
//        }



        /**
         * 对value进行排序
         */
       Set<Map.Entry<String, Integer>> entries = phone.entrySet();
        //先把  视图set  转换维list

        List<Map.Entry<String, Integer>> list=new ArrayList<>(entries);

        /**
         * 再用list.sort(list,comparator)或者
         * Collections.sort(list,comparator)对list进行排序
         */

        /**
         * 升序排序，分为下面3种
         */
        //Collections.sort(list,(o1, o2)->(o1.getValue().compareTo(o2.getValue())));//String比较用compareTo
        //Collections.sort(list,(o1, o2)->((o1+o2).compare(o2+o1)))//还可以自定义比较规则
        Collections.sort(list,(o1, o2)->(o1.getValue()-o2.getValue()));//整数可以直接用'-'号

        /**
         * 降序排序，分为下面3种
         */
        //Collections.sort(list,(o1, o2)->(o2.getValue().compareTo(o1.getValue())));//String比较用compareTo
        //Collections.sort(list,(o1, o2)->((o1+o2).compare(o2+o1)))//还可以自定义比较规则
        Collections.sort(list,(o1,o2)->(o2.getValue()-o1.getValue()));

        /**
         * 打印hashmap里面的元素，分为下面2种
         */
        for (Map.Entry<String, Integer> mapping:list){
            System.out.println(mapping.getKey()+" : "+mapping.getValue());
        }

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getKey()+" : "+list.get(i).getValue());
        }

    }

    public static void main(String[] args) {
        MapSortExample mapTest=new MapSortExample();
        mapTest.sortHashMap();
    }
}

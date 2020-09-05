package com.huster.leetcode.SwordToOffer.PartitionFour;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/4/11
 * Description:最长不含重复字符的子字符串
 * Status:要先理清思路
 */
public class test48 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s;
        while (sc.hasNext()){
           s=sc.next();
           System.out.println(getlengthOfLongestSubstring4(s));
        }
        sc.close();
   }

    /**
     * 剑指offer上的解法，不推荐
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int curLength=0;  //curLength = f(i)
        int MaxLength=0;
        int[] position=new int[26];
       // HashMap h=new HashMap(26);
        Arrays.fill(position,-1);
        for (int i = 0; i < s.length(); i++) {
            int c  = s.charAt(i)-'a';
            int preIndex=position[c];//求这个字符串在其中出现的前位置
                    //未出现       与前一次出现的距离大于当前最大值
            if (preIndex == -1 || i-preIndex>curLength){
                //f(i)=f(i-1)+1
                curLength++;
            }else {
                //在字符串里面 i-preIndex<=curLength
                MaxLength=Math.max(curLength,MaxLength);
                curLength= i-preIndex;
            }
            //往里面存
            position[c]=i;
        }
        MaxLength=Math.max(curLength,MaxLength);
        return MaxLength;
    }

    /**
     * 另外的一种解决滑动串口的思路
     * 这种思路简洁明了
     * @param s
     * @return
     */
    public static int getlengthOfLongestSubstring3(String s){
        Set<Character> set=new HashSet<>();
        int left=0,right=0,max=0;
         while(right<s.length()){
             if (set.contains(s.charAt(right))){
                 set.remove(s.charAt(left));//我的微保考试就在这里挂了，忘记了，蛋疼。MD不能本地IDEA
                 left++;
             }
             set.add(s.charAt(right));
             right++;
             //因为right已经做了+1操作，下面的为right-left
             max=Math.max(right-left,max);
         }
        return max;
    }
    /**
     * 优化一下，就是对其中的用hashmap来存储
     */
    public static int getlengthOfLongestSubstring4(String s){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int head=0,max=0;
        for (int tail = 0; tail < s.length(); tail++) {
            if (hashMap.containsKey(s.charAt(tail))){
                head=Math.max(hashMap.get(s.charAt(tail)),head);
            }
            //此处tail+1，是让头指针直接指向重复元素位置的下一个位置
            hashMap.put(s.charAt(tail),tail+1);
            max=Math.max(max,tail-head+1);
        }
        return max;
    }
}


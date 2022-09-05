package com.huster.leetcode.SwordToOffer.PartitionFive;

import com.huster.leetcode.utils.ListNode;

import java.util.ArrayDeque;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description: 滑动窗口的最大值
 */
public class Test59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.getFirst() <= (i - k)) {
                deq.removeFirst(); //最大值对应的索引已超出K的最左边范围
            }
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();  //k个保持单调递减
            }
            deq.addLast(i); //加入值的索引
            if (i >= k - 1) {
                res[i - k + 1] = nums[deq.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

    /**
     * @author Created by Divo
     * @date 2020/4/12
     * Description:数组中的逆序对，采用归并排序
     * Status:这个写法很厉害，可以借鉴一下
     */
    public static class test51 {
        public static void main(String[] args) {
            int[] a = new int[]{7, 5, 6, 4};
            InversePairs(a);
            System.out.println(count);
        }

        private static int count = 0;
        //static int temp[];

        public static int InversePairs(int[] array) {
            mergeSort(array, 0, array.length - 1);
            return count;
        }

        public static void mergeSort(int[] array, int l, int h) {
            if (h - l < 1) {   //判断结束条件
                return;
            }
            int m = (l + h) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, h);
            merge(array, l, m, h);

        }

    //        private static void merge(int[] array,int l,int m,int h){
    //        //分为2段  [l,m] [m+1,h]
    //        int i=l,j=m+1,k=l;
    //        //常规思路：将2部分按照规则进行排序到temp数组，然后对2部分剩下的继续放入（拼接）
    //        while (i<=m || j<=h){
    //            if (i>m){   //j<=h条件成立，数组[m+1,h]还有剩下的
    //                temp[k]=array[j++];
    //            }else if(j>h){  //i<=m条件成立，数组[l,m]还有剩下的
    //                temp[k]=array[i++];
    //            }else if(array[i]<array[j]){//不构成逆序的条件
    //                temp[k]=array[i++];
    //            }else {  //numes[i]>=nums[j]
    //                temp[k] = array[j++];
    //                count += (m-i+1);//说明 nums[i...mid] 都大于 nums[j]
    //            }
    //            k++;
    //        }

            //直接把相应的片段复制过去
    //        for ( k = l; k <= h; k++) {
    //            array[k]=temp[k];
    //        }
       // }
        /**
         * 常规递归的思路代码
         */
        public static void merge(int[] a,int start,int mid,int end){
            int[] temp=new int[end-start+1];
            int i=start,j=mid+1,k=0;
            while (i<=mid && j<=end){
                if (a[i]<=a[j]){
                    temp[k++]=a[i++];
                }else {
                    temp[k++]=a[j++];//违反了顺序
                    count += (mid-i+1);//说明 nums[i...mid] 都大于 nums[j]
                    count%=1000000007;
                }
            }
            while (i<=mid){
                temp[k++]=a[i++];
            }
            while (j<=end){
                temp[k++]=a[j++];
            }
            for (int l = 0; l < temp.length; l++) {
                a[start+l]=temp[l];
            }
        }

    }

    /**
     * @author Created by Divo
     * @date 2020/4/14
     * Description:2个链表的第一个公共节点
     * Status:
     */
    public static class test52 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            //1、先遍历2个表的长度，长的先走2个的差，第一个相等的就是他了
            //2、先遍历2个数组，然后入栈。按照顺序弹出，最后一个相等的就是他了
            // 3、a+c  b+c   a+c+b=b+c+a
            ListNode p1=pHead1,p2=pHead2;
            while (p1 != p2){
                 p1=(p1 ==null)? pHead2 : p1.next;
                 p2=(p2 ==null)? pHead1 : p2.next;
            }
            return p1;

        }
    }
}

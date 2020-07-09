package com.huster.leetcode.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/12
 * Description:数组中的逆序对，采用归并排序
 * Status:这个写法很厉害，可以借鉴一下
 */
public class test51 {
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
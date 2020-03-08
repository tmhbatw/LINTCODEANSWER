package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1623 {
    /*Description
    *给定两个整数数组a和b,要求对于b中的每个数值,找出a中和它距离最小的数（即两数差的绝对值最小）,
    * 如果出现距离相等的情况，输出较小的那个数。最后返回一个长度为b.length的数组来表示答案。
    * */

    public int[] minimalDistance(int[] a, int[] b) {
        Arrays.sort(a);
        int[] result=new int[b.length];
        for(int i=0;i<b.length;i++){
            result[i]=getResult(a,b[i]);
        }
        return result;
        // Write your code here
    }

    private int getResult(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(array[mid]==target||array[mid]>target&&mid==0||array[mid]<target&&mid==array.length-1)
                return array[mid];
            if(array[mid]>target&&array[mid-1]<target)
                return target-array[mid-1]<=array[mid]-target?array[mid-1]:array[mid];
            if(array[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }


}

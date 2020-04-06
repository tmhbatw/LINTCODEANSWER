package LINTCODE10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LINTCODE940 {
    /*Description
    * 给定一个整数数组A，从中选出n个数，使得这个n个数中两两之差的绝对值的最小值尽可能大。你需要返回这个最大的绝对值。
    * */

    public int maximumAbsolutValue(int[] A, int n) {
        if(A==null||A.length==0||n<=1)
            return 0;
        Arrays.sort(A);
        int left=1,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int count=getNumber(A,mid);
            if(count>=n&&getNumber(A,mid+1)<n)
                return mid;
            if(count<n)
                right=mid-1;
            else{
                left=mid+1;
            }
        }
        return left;
        // Write your code here
    }

    private int getNumber(int[] A,int diff){
        int lastNumber=A[0];
        int count=1;
        for(int i=1;i<A.length;i++){
            if(A[i]-lastNumber>=diff){
                count++;
                lastNumber=A[i];
            }
        }
        return count;
    }
}

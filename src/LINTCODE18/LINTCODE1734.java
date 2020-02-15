package LINTCODE18;

import java.util.Arrays;
import java.util.Stack;

public class LINTCODE1734 {
    /*Description
    * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
    * 由于答案可能很大，因此返回答案模 10^9 + 7。
    * */

    public int sumSubarrayMins(int[] A) {
        long result=0;
        for(int i=0;i<A.length;i++){
            int left=0;
            int index=i;
            while(index>0&&A[index-1]>A[i])
                index--;
            left=i-index+1;
            int right=0;
            index=i;
            while(index<A.length-1&&A[index+1]>=A[i])
                index++;
            right=index-i+1;
            result+=left*right*A[i];
        }
        return (int) (result%(1000000007));
        // Write your code here.
    }
}

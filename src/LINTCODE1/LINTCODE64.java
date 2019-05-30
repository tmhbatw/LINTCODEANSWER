package LINTCODE1;

import java.util.Arrays;

public class LINTCODE64 {

    /*Description
    * Given two sorted integer arrays A and B, merge B into A as one sorted array.
    * */

    /*Solution
    * 简单的遍历排序即可
    * 逐个比较A、B数组当前数字并将较小的数输入到结果数组中
    * */


    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] result=new int[m+n];
        B=Arrays.copyOf(B,n+1);
        A[m]=Integer.MAX_VALUE;
        B[n]=Integer.MAX_VALUE;
        int a=0;
        int b=0;
        for(int i=0;i<m+n;i++){
            result[i]=Math.min(A[a],B[b]);
            if(result[i]==A[a])
                a++;
            else
                b++;
        }
        for(int i=0;i<m+n;i++)
            A[i]=result[i];
    }
}

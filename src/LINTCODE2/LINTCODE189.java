package LINTCODE2;

import java.util.Arrays;

public class LINTCODE189 {
    /*Description
    * 给出一个无序的整数数组，找出其中没有出现的最小正整数。
    * */

    /*Solution
    * 使用O(n)空复杂度可以轻松满足题目要求
    * 如果不能使用额外空间的话那么需要对数组进行对调
    * 将数字A[i]与A[A[i]-1]进行对调，持续进行这一操作，直到A[i]=i+1或者A[i]是一个负数
    * */

    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
            while(A[i]!=i+1&&A[i]<=A.length&&A[i]>0){
                int temp=A[A[i]-1];
                A[A[i]-1]=A[i];
                A[i]=temp;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)
                return i;
        }
        return A.length+1;
        // write your code here
    }


/*    public int firstMissingPositive(int[] A) {
        if(A.length<1)
            return 1;
        int[] dp=new int[A.length+1];
        for(int i=0;i<A.length;i++){
            if(A[i]<0||A[i]>A.length)
                continue;
            dp[A[i]]=1;
        }
        System.out.println(Arrays.toString(dp));
        for(int i=1;i<dp.length;i++){
            if(dp[i]==0)
                return i;
        }
        return -1;
        // write your code here
    }*/

}

package LINTCODE2;

import java.util.Arrays;

public class LINTCODE197 {
    /*Description
    *Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.
    * */

    /*Solution
    *
    * */

    public long permutationIndex(int[] A) {
        Long[] dp=new Long[A.length];
        dp[dp.length-1]= Long.valueOf(1);
        for(int i=1;i<dp.length;i++){
          dp[dp.length-1-i]=dp[dp.length-i]*i;
        }
        Long res=0l;
        for(int i=0;i<A.length;i++){
            int count=0;
            for(int j=i+1;j<A.length;j++){
                if(A[j]<A[i])
                    count++;
            }
            res+=count*dp[i];
        }
        return res+1;
        // write your code here
    }
}

package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1591 {
    /*Description
    * 给定一个整数数组 A ，思考 A 的所有非空子序列。
    * 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
    * 返回 A 的所有子序列的宽度之和。
    * 由于答案可能非常大，请返回答案模 10^9+7。
    * */
    public int sumSubseqWidths(int[] A) {
        if(A.length<=1)
            return 0;
        int[] dp=new int[A.length+1];
        dp[1]=1;
        int mod = 1000000007;
        for(int i=2;i<A.length+1;i++){
            dp[i] = dp[i-1]*2%mod;
        }
        Arrays.sort(A);
        long res = 0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                res += (long) dp[j-i] *(A[j]-A[i]);
                res %= mod;
            }
        }
        return (int)res;
        // write your code here
    }

}

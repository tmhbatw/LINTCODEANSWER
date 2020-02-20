package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1284 {
    /*Description
    *给定一个正整数 n ，将其拆分成至少两个正整数之和，并且使这些整数之积最大。返回这个最大乘积。
    * */

    public int integerBreak(int n) {
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[j],j*dp[i-j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
        // Write your code here
    }
}

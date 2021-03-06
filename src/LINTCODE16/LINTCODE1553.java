package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1553 {
    /*Description
    * 小明准备爬上一个n个台阶的楼梯，当他位于第i级台阶时，他可以往上走1至num[i]级台阶。
    * 问小明有多少种爬完楼梯的方法？由于答案可能会很大，所以返回答案对1e9+7取模即可。
    * */

    public long Solve(int n, int[] num) {
        int mod=1000000007;
        int[] dp=new int[n+2];
        dp[0]=1;
        dp[1]=-1;
        int res=0;
        for(int i=0;i<n;i++){
            res=(res+dp[i])%mod;
            int L=i+1;
            int R=Math.min(n+1,i+1+num[i]);
            dp[L]=(dp[L]+res)%mod;
            dp[R]=(dp[R]-res)%mod;
        }
        return (dp[n]+res)%mod;
        // Write your code here
    }


}

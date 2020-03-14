package LINTCODE9;

import java.util.Arrays;

public class LINTCODE801 {
    /*Description
    * 你总共有n元，商人总共有三种商品，它们的价格分别是150元,250元,350元，三种商品的数量可以认为是无限多的，
    * 购买完商品以后需要将剩下的钱给商人作为小费，求最少需要给商人多少小费
    * */

    public int backPackX(int n) {
        int last=n%50;
        n/=50;
        int[] dp=new int[n>7?n+1:8];
        dp[0]=dp[3]=dp[5]=dp[6]=dp[7]=0;
        dp[1]=dp[4]=1;
        dp[2]=2;
        for(int i=8;i<=n;i++){
            dp[i]=Math.min(dp[i-3],Math.min(dp[i-5],dp[i-7]));
        }
        return dp[n]*50+last;
        // write your code here
    }
}

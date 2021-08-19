package LINTCODE4;

import java.util.Arrays;

public class LINTCODE332 {
    /*Description
    * 小九有一个长为 n 的整型数组，数组中的每个数都在
    * l 和 r 之间，而且数组的和是 3 的整数倍。
    * 请帮小九计算出这个数组一共有多少种不同的可能。
    * 输出要对 10的9次方+7取模
    * */

    public int restoreArray(int n, int l, int r) {
        if(n==0)
            return 0;
        long[][] dp=new long[n][3];
        dp[0][0]=dp[0][1]=dp[0][2]=(l-r)/3;
        for(int i=r+(l-r)/3*3;i<=l;i++){
            dp[0][i%3]++;
        }
        int mod=1000000007;
        for(int i=1;i<n;i++){
            dp[i][0]=((dp[i-1][0]+dp[0][0])+(dp[i-1][1]+dp[0][2])+(dp[i-1][2]+dp[0][1]))%mod;
            dp[i][1]=((dp[i-1][0]+dp[0][1])+(dp[i-1][2]+dp[0][2])+(dp[i-1][1]+dp[0][0]))%mod;
            dp[i][2]=((dp[i-1][0]+dp[0][2])+(dp[i-1][1]+dp[0][0])+(dp[i-1][2]+dp[0][0]))%mod;
        }
        for(long[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }
        return (int)dp[n-1][0];
        // write your code here.
    }

    public static void main(String[] args){
        long res=Integer.MAX_VALUE+Integer.MAX_VALUE;
        System.out.println(res);
    }
}

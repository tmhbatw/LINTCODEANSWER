package LINTCODE11;

public class LINTCODE1026 {
    /*Description
    *
    * */

    public int numTilings(int N) {
        int mod=1000000007;
        long[] dp=new long[Math.max(N+1,5)];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for(int i=4;i<=N;i++){
            dp[i]=dp[i-4]*2+dp[i-3]*2+dp[i-2]+dp[i-1];
            for(int j=0;j<=i-5;j++){
                dp[i]+=2*dp[i-j-5];
            }
            dp[i]%=mod;
        }
        return (int)dp[N];
        // write your code here
    }
}

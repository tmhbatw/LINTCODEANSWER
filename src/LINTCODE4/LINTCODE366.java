package LINTCODE4;

public class LINTCODE366 {
    /*Description
    * 斐波那契数列
    * */

    public int fibonacci(int n) {
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        int[] dp=new int[n+1];
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
        // write your code here
    }
}

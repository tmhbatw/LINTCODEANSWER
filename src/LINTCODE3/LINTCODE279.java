package LINTCODE3;

public class LINTCODE279 {
    /*Description
    * 给你无限多个的 25 分，10 分，5 分和 1 分的硬币。问如果要凑出 n 分钱有多少种不同的方式？
    * */

    public int waysNCents(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            dp[i]+=dp[i-1];
        }
        for(int i=5;i<=n;i++){
            dp[i]+=dp[i-5];
        }
        for(int i=10;i<=n;i++){
            dp[i]+=dp[i-10];
        }
        for(int i=25;i<=n;i++){
            dp[i]+=dp[i-25];
        }
        return dp[n];
        // write your code here
    }
}

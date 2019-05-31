package LINTCODE2;

public class LINTCODE111 {
    /*Description
    * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
    * */

    /*Solution
    * 非常典型的动态规划不费口舌
    * */

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        // write your code here
    }
}

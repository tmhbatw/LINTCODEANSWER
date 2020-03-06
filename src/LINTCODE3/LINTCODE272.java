package LINTCODE3;

public class LINTCODE272 {
    /*Description
    * 一个小孩爬一个 n 层台阶的楼梯。他可以每次跳 1 步， 2 步 或者 3 步。实现一个方法来统计总共有多少种不同的方式爬到最顶层的台阶。
    * */

    public int climbStairs2(int n) {
        if(n==0)
            return 1;
        if(n<=2)
            return n;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        return dp[n];
        // write your code here
    }
}

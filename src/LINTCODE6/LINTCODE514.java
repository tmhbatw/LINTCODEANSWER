package LINTCODE6;

public class LINTCODE514 {
    /*Description
    * 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
    * 必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。
    * */

    /*Solution
    * 动态规划
    * 创建一个dp数组，dp[i]用来表示第n个柱子染色的情况数
    * 那么第i个柱子可以和i-1个柱子颜色不同，为dp[i-1]*(k-1)
    * 也可以和第i-i个柱子的 颜色相同，为dp[i-2]*(k-1)
    * */

    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        if(n==1)
            return k;
        int[] dp=new int[n];
        dp[0]=k;
        dp[1]=k*k;
        for(int i=2;i<n;i++){
            dp[i]=(dp[i-1]+dp[i-2])*(k-1);
        }
        return dp[n-1];
        // write your code here
    }
}

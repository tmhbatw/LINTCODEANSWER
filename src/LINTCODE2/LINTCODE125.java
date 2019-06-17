package LINTCODE2;

public class LINTCODE125 {
    /*Description
    * There are n items and a backpack with size m. Given array A representing the size of each item and array V representing the value of each item.
    * What's the maximum value can you put into the backpack?
    * */

    /*Solution
    * 背包问题的经典问题
    * 创建一个dp[][]数组其中dp[i][j]用来表示j空间大小的背包存储前i个物件的最大价值
    * */

    public int backPackII(int m, int[] A, int[] V) {
        int[][] dp=new int[A.length+1][m+1];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<=m;j++){
                if(j<A[i])
                    dp[i+1][j]=dp[i][j];
                else{
                    dp[i+1][j]=Math.max(dp[i][j],dp[i][j-A[i]]+V[i]);
                }
            }
        }
        return dp[A.length][m];
        // write your code here
    }
}

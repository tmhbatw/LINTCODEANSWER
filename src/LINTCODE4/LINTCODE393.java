package LINTCODE4;

public class LINTCODE393 {
    /*与151题解题思路完全相同
    *
    * */

    public int maxProfit(int K, int[] prices) {
        int[][] dp=new int[K+1][prices.length+1];
        int[][] result=new int[K+1][prices.length+1];
        for(int i=1;i<K+1;i++){
            for(int j=2;j<prices.length+1;j++){
                dp[i][j]=Math.max(result[i-1][j-1], dp[i][j-1] +prices[j-1]- prices[j-2]);
                result[i][j]=Math.max(result[i][j-1],dp[i][j]);
            }
        }
        return result[K][prices.length];
        // write your code here
    }
}

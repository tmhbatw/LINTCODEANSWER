package LINTCODE5;

public class LINTCODE436 {

    /*Description
    *Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
    * */

    /*Solution
    * 动态规划，假设dp[i][j]表示包含点（i，j)的正方形的最大边长，那么dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1或者0
    * */


    public int maxSquare(int[][] matrix) {
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    continue;
                dp[i+1][j+1]=1+Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]));
                result=Math.max(dp[i+1][j+1],result);
            }
        }
        return result;
        // write your code here
    }
}

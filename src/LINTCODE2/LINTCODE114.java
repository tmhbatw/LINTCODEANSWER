package LINTCODE2;

import java.util.Arrays;

public class LINTCODE114 {

    /*Description
    * A robot is located at the top-left corner of a m x n grid.
    * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
    * How many possible unique paths are there?
    *
    * */

    /*Solution
    * 典型的动态规划问题
    * */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1]+=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[m][n];
        // write your code here
    }
}

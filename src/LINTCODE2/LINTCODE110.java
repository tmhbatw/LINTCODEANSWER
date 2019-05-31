package LINTCODE2;

public class LINTCODE110 {

    /*Description
    * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    * */

    /*Solution
    *动态规划
    * */

    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row+1][col+1];
        for(int i=1;i<row+1;i++){
            dp[i][0]=Integer.MAX_VALUE;
        }
        for(int i=1;i<col+1;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i+1][j+1]=Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j];
            }
        }
        return dp[row][col];

        // write your code here
    }
}

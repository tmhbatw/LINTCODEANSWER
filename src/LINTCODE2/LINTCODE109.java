package LINTCODE2;

import java.util.Arrays;

public class LINTCODE109 {
    /*Description
    * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    * */

    /*Solution
    * 动态规划
    * */

    public int minimumTotal(int[][] triangle) {
        int row=triangle.length;
        if(row==1)
            return triangle[0][0];
        int col=triangle[row-1].length;
        int[][] dp=new int[row][col];
        dp[0][0]=triangle[0][0];
        for(int i=1;i<row;i++){
            dp[i][0]=triangle[i][0]+dp[i-1][0];
            dp[i][i]=triangle[i][i]+dp[i-1][i-1];
        }
        for(int i=2;i<row;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+
                        triangle[i][j];
            }
        }
        int result=Integer.MAX_VALUE;
        for(int j=0;j<col;j++){
            result=Math.min(result,dp[row-1][j]);
        }
        return result;
        // write your code here
    }
}

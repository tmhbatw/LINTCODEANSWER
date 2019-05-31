package LINTCODE2;

import java.util.Arrays;

public class LINTCODE115 {
    /*Description
    * Follow up for "Unique Paths":
    * Now consider if some obstacles are added to the grids. How many unique paths would there be?
    * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    * */

    /*Solution
    * 动态规划，与114题相似
    * 增加一步障碍判断即可(如果当前节点为一个石头，那么经过它的路线一定为0条
    * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        dp[1][1]=1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1) {
                    dp[i + 1][j + 1] =0;
                }else{
                    dp[i+1][j+1]+=dp[i][j+1]+dp[i+1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        // write your code here
    }
}

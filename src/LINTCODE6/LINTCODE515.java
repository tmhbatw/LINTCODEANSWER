package LINTCODE6;

public class LINTCODE515 {
    /*Description
    *这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
    * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
    * */

    /*Solution
    * 动态规划
    * 创建一个dp[][]数组，其中dp[i][k]用来表示第i个房间染第k种颜色的最小价格
    * */

    public int minCost(int[][] costs) {
        int length=costs.length;
        if(length==0)
            return 0;
        int[][] dp=new int[length+1][3];
        for(int i=1;i<length+1;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i-1][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i-1][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+costs[i-1][2];
        }
        return Math.min(dp[length][0],Math.min(dp[length][1],dp[length][2]));
        // write your code here
    }
}

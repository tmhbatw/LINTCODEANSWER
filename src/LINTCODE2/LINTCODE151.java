package LINTCODE2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE151 {

    /*Description
    * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
    * */

    /*Solution
    *动态规划
    * 创建一个动态数组dp[i][j]其中dp[i][j]表示i天进行最多j次操作，且一定要包含当前股票出售的最大利润
    * 创建一个结果数组，其中result[i][j]表示i天进行最多j次操作且不一定要包含当前股票出售的最大利润
    * */
    public int maxProfit(int[] prices) {
        int[][] dp=new int[3][prices.length+1];
        int[][] result=new int[3][prices.length+1];
        for(int i=1;i<3;i++){
            for(int j=2;j<prices.length+1;j++){

                dp[i][j]=Math.max(result[i-1][j-1], Math.max(dp[i][j-1] +prices[j-1]- prices[j-2],0));
                result[i][j]=Math.max(result[i][j-1],dp[i][j]);
            }
        }
        return result[2][prices.length];
        // write your code here
    }
}

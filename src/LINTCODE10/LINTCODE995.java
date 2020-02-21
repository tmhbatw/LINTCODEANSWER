package LINTCODE10;

import java.util.Arrays;

public class LINTCODE995 {
    /*Description
    * 假设你有一个数组，第 i 个元素表示给出股票第 i 天的价格。
    * 设计一个算法来得到最大的利润。你可以通过以下限制完成任意数量的交易（即买入并多次卖出一股股票）：
    * 你不能同时进行多笔交易（即，必须在再次购买之前卖出股票）。
    * 在你出售股票后，无法在第二天购买股票。 （即冷却1天）
    * */

    public int maxProfit(int[] prices) {
        int result=0;
        int[] dp=new int[prices.length+2];
        dp[0]=prices[0];
        for(int i=0;i<prices.length;i++){
            dp[i+2]=dp[i+1];
            for(int j=0;j<i;j++){
                dp[i+2]=Math.max(dp[i+2],dp[j]+prices[i]-prices[j]);
            }
        }
        System.out.println(Arrays.toString(prices));
        return dp[prices.length+1];
        // write your code here
    }
}

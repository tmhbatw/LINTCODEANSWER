package LINTCODE15;

public class LINTCODE1448 {
    /*Description
    * 现在有一个卡牌游戏，先给出卡牌的数量n，再给你两个非负整数totalProfit、totalCost，
    * 然后给出每张卡牌的利润值 a[i]和成本值b[i]，现在可以从这些卡牌中任意选择若干张牌，组成一个方案，
    * 问有多少个方案满足所有选择的卡牌利润和大于totalProfit且成本和小于totalCost。
    * */

    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        int[][][] dp=new int[n+1][totalCost][totalProfit+2];
        dp[0][0][0]=1;
        int mod=1000000009;
        for(int i=0;i<n;i++){
            for(int j=0;j<totalCost;j++){
                for(int k=0;k<totalProfit+2;k++){
                    dp[i+1][j][k]=dp[i][j][k];
                }
            }
            for(int j=0;j<totalCost-b[i];j++){

                for(int k=0;k<=totalProfit+1;k++){
                    dp[i+1][j+b[i]][Math.min(k+a[i],totalProfit+1)]=
                            (dp[i+1][j+b[i]][Math.min(k+a[i],totalProfit+1)]+dp[i][j][k])%mod;
                }
            }
        }
        int result=0;
        for(int j=0;j<totalCost;j++){
            result=(result+dp[n][j][totalProfit+1])%mod;
        }
        return result;
        // Write your code here
    }
}

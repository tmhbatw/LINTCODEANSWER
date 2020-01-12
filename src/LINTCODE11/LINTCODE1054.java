package LINTCODE11;

public class LINTCODE1054 {
    /*Description
    *在楼梯上，每一号台阶都有各自的费用，即第 i 号台阶有非负成本cost [i]（台阶从0号索引）。
    * 一旦你支付了费用，你可以爬一到两步。 你需要找到最低成本来到达最高层，你可以从索引为0的楼梯开始，也可以从索引为1的楼梯开始。
    * */

    public int minCostClimbingStairs(int[] cost) {
        if(cost==null||cost.length==0)
            return 0;
        if(cost.length==1)
            return cost[0];
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++)
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
        // Write your code here
    }
}

package LINTCODE4;

public class LINTCODE395 {
    /*Description
    *有 n 个不同价值的硬币排成一条线。两个参赛者轮流从 左边 依次拿走 1 或 2 个硬币，直到没有硬币为止。
    * 计算两个人分别拿到的硬币总价值，价值高的人获胜。
    * 请判定 先手玩家 必胜还是必败?
    * */

    /*Solution
    * 动态规划方法
    * 因为从前往后分析过于复杂以及拿硬币需要考虑硬币堆后面的情况来进行拿取，我们可以选择从后往前对第一个人拿取硬币堆进行分析
    * 获取第一个人所能拿到的最大硬币后，通过与总数之间相减即可进行比较
    * */

    public boolean firstWillWin(int[] values) {
        if(values.length<=2)
            return true;
        int n=values.length;
        int[] dp=new int[n+1];
        dp[n-1]=values[n-1];
        dp[n-2]=values[n-2]+values[n-1];
        dp[n-3]=values[n-3]+values[n-2];
        for(int i=n-4;i>=0;i--){
            dp[i]=Math.max(values[i]+Math.min(dp[i+2],dp[i+3]),values[i]+values[i+1]+Math.min(dp[i+3],dp[i+4]));
        }
        for(int val:values)
            dp[n]+=val;
        return 2*dp[0]>dp[n];
        // write your code here
    }
}

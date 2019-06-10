package LINTCODE4;

public class LINTCODE392 {
    /*Description
    * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：
    * 相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
    * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
    * */

    /*Solution
    * 动态规划
    * 可以创建一个数组dp[]其中，dp[i]用来保存偷到第i家的时候，最多可以偷多少东西
    * 那么dp[i]=dp[i-1]或者的dp[i-2]+num[i]之间的最大值
    * 遍历即可
    * */

    public long houseRobber(int[] A) {
        if(A.length==0)
            return 0;
        if(A.length==1)
            return A[0];
        if(A.length==2)
            return Math.max(A[0],A[1]);
        Long[] dp=new Long[A.length];
        dp[0]= Long.valueOf(A[0]);
        dp[1]= Long.valueOf(A[1]);
        for(int i=2;i<A.length;i++){
            dp[i]=Math.max(A[i]+dp[i-2],dp[i-1]);
        }
        return dp[A.length-1];
        // write your code here
    }
}

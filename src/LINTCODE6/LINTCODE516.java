package LINTCODE6;

public class LINTCODE516 {

    /*Description
    * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
    * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。
    * */

    /*Solution
    * 动态规划
    * */

    public int minCostII(int[][] costs) {
        if(costs.length==0)
            return 0;
        if(costs[0].length==1){
            int result=0;
            for(int i=0;i<costs.length;i++){
                result+=costs[i][0];
            }
            return result;
        }
        int[][] dp=new int[costs.length+1][costs[0].length];
        for(int i=1;i<dp.length;i++){
            int[] lastMin=getLastMin(dp,i-1);
            for(int j=0;j<costs[0].length;j++){
                if(dp[i-1][j]==lastMin[0]){
                    dp[i][j]=lastMin[1]+costs[i-1][j];
                }else
                    dp[i][j]=lastMin[0]+costs[i-1][j];
            }
        }
        int min=Integer.MIN_VALUE;
        for(int i=0;i<dp[0].length;i++){
            min=Math.min(min,dp[costs.length][i]);
        }
        return min;
        // write your code here
    }

    private int[] getLastMin(int[][] num,int n){
        int[] result=new int[2];
        int fmin=Integer.MAX_VALUE-1;
        int smin=Integer.MAX_VALUE;
        for(int i=0;i<num[0].length;i++){
            int cur=num[n][i];
            if(cur<=fmin){
                smin=fmin;
                fmin=cur;
            }else if(cur<=smin){
                smin=cur;
            }
        }
        result[0]=fmin;
        result[1]=smin;
        return result;
    }
}

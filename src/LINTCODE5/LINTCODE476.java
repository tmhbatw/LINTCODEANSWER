package LINTCODE5;

public class LINTCODE476 {

    /*Description
    *有一个石子归并的游戏。最开始的时候，有n堆石子排成一列，目标是要将所有的石子合并成一堆。合并规则如下：
    * 每一次可以合并相邻位置的两堆石子
    * 每次合并的代价为所合并的两堆石子的重量之和
    * 求出最小的合并代价
    * */

    /*Solution
    *动态规划试一下
    * 开始的思考欠妥当了，多加了不必要的消耗
    * 应该创建一个dp[][]数组，用来保存从i到j的石头合并的最小代价
    * */

    public int stoneGame(int[] A) {
        if(A.length<=1)
            return 1;
        int n=A.length;
        int[][] dp=new int[n][n];
        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                dp[i][j]=Integer.MAX_VALUE;
                int count=0;
                for(int m=i;m<=j;m++)
                    count+=A[m];
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+count);
                }
            }
        }
        return dp[0][n-1];
        // write your code here
    }



}

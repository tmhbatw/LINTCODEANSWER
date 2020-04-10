package LINTCODE6;

public class LINTCODE584 {
    /*Description
    *有一个n层的建筑。如果一个鸡蛋从第k层及以上落下，它会碎掉。如果从低于这一层的任意层落下，都不会碎。
    * 有m个鸡蛋，用最坏的情况下实验次数最少的方法去找到k, 返回最坏情况下所需的实验次数。
    * */

    public int dropEggs2(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][1]=1;
            dp[i][0]=0;
        }
        for(int j=1;j<=n;j++){
            dp[1][j]=j;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],1+Math.max(dp[i-1][k-1],dp[i][j-k]));
                }
            }
        }
        return dp[m][n];
        // write your code here
    }
}

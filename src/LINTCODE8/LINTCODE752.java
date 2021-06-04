package LINTCODE8;

public class LINTCODE752 {
    /*Description
    *在物质位面“现实”中，有n+1个星球，分别为星球0，星球1，……，星球n。
    * 每一个星球都有一个传送门，通过传送门可以直接到达目标星球而不经过其他的星球。不过传送门有两个缺点。
    * 第一，从星球i通过传送门只能到达编号比i大，且与i的差不超过limit的星球。
    * 第二，通过传送门到达星球j，需要cost[j]个金币。
    * 现在，流浪剑客斯温到达星球0后身上有m个金币，请问他有多少种方法通过传送门到达星球n？
    * */

    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        long[][] dp=new long[n+1][m+1];
        for(int i=0;i<n;i++){
                for (int k = 1; k <= limit; k++) {
                    if (i + k > n)
                        break;
                    for(int j=cost[i+k];j<=m;j++)
                        dp[i+k][j-cost[i+k]]+=dp[i][j];
                }
        }
        long result=0;
        for(int j=0;j<=m;j++)
            result+=dp[n][j];
        return result;
        //
    }

}

package LINTCODE4;

public class LINTCODE396 {
    /*Description
    * 有 n 个硬币排成一条线, 第 i 枚硬币的价值为 values[i].
    * 两个参赛者轮流从任意一边取一枚硬币, 直到没有硬币为止. 拿到硬币总价值更高的获胜.
    * 请判定 第一个玩家 会赢还是会输.
    * */

    public boolean firstWillWin(int[] values) {
        int length=values.length;
        int[][] dp=new int[length][length];//其中dp[i][j]表示从第i个数到第j个数能取到的最大的分值
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+values[i];
        for(int i=0;i<length;i++)
            dp[i][i]=values[i];
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i][j]=Math.max(values[i]+sum[j+1]-sum[i+1]-dp[i+1][j],
                        values[j]+sum[j]-sum[i]-dp[i][j-1]);
            }
        }
        return dp[0][length-1]*2>sum[length];
        // write your code here
    }
}

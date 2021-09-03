package LINTCODE16;

public class LINTCODE1574 {
    /*Description
    * 小明喜欢在火车旅行的时候用手机听音乐，他有n首歌在手机里，在整个火车途中，
    * 他可以听p首歌，所以他想产生一个播放表产生p首歌曲，这个播放表的规则是：
    * (1)每首歌都要至少被播放一次
    * (2)在两首一样的歌中间，至少有m首其他的歌
    * 小明想知道有多少种不同的播放表可以产生。由于结果较大，输出结果模1000000007的余数。
    * */

    int mod=1000000007;
    public int getAns(int n, int m, int p) {
        int[][] dp=new int[p][n+1];
        dp[0][1]=n;
        for(int i=1;i<p;i++){
            for(int j=1;j<=n;j++){
                long cur= (long) dp[i - 1][j - 1] *(n-j+1)+ (long) dp[i - 1][j] *Math.max(0,j-m);
                cur%=mod;
                dp[i][j]=(int)cur;
            }
        }
        return dp[p-1][n];
        // Write your code here
    }
}

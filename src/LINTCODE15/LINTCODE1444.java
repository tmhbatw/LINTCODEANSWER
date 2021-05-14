package LINTCODE15;

public class LINTCODE1444 {
    /*Description
    * 有一个圆形，分成n个扇形，用m种颜色给每个扇形染色，相邻扇形颜色不能相同。求方案总数。
    * */

    public int getCount(int n, int m) {
        //dp表示的是当这个圆形中扇形个数为i时染色方案数，包含两种情况，第N-1个节点与第i个节点颜色相同，第N-1个节点与第i个节点颜色不同
        long[] dp=new long[n+4];
        int mod=1000000007;
        dp[1]=m;
        dp[2]=dp[1]*(m-1)%mod;
        dp[3]=dp[2]*(m-2)%mod;
        for(int i=4;i<=n;i++)
            dp[i]=(dp[i-1]*(m-2)+dp[i-2]*(m-1))%mod;
        return (int)dp[n];
        // Write your code here
    }
}

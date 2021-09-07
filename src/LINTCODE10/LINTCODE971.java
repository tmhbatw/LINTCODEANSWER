package LINTCODE10;

import java.util.Arrays;
import java.util.OptionalLong;

public class LINTCODE971 {
    /*Description
    * 有一个容量为 c 的背包。
    * 有 n 个 A 类物品，第 i 个 A 类物品的体积为 a[i]，物品的价值为装入该物品后背包剩余容量 * k1。
    * 有 m 个 B 类物品，第 i 个 B 类物品的体积为 b[i]，物品的价值为装入该物品后背包剩余容量 * k2。
    * 求最大可以获得的价值。
    * */

    public long getMaxValue(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
        //dp保存的是当使用i个A类物品的最大值，left保存使用i个A类物品背包的剩余容量
        long[][] dp=new long[n+1][m+1];
        Arrays.sort(a);
        Arrays.sort(b);

        long[] sum1=new long[n+1];
        for(int i=0;i<n;i++)
            sum1[i+1]=sum1[i]+a[i];

        long[] sum2=new long[m+1];
        for(int i=0;i<m;i++){
            sum2[i+1]=sum2[i]+b[i];
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                long left=c-sum1[i]-sum2[j];
                if(left<0)
                    break;
                long dp1=(i==0?0:dp[i-1][j]+ left *k1);
                long dp2=(j==0?0:dp[i][j-1]+ left *k2);
                dp[i][j]=Math.max(dp1,dp2);
            }
        }
        long result=0;
        for(long[] cur:dp){
            for(long curr:cur){
                result=Math.max(curr,result);
            }
        }

        return result;
        // Write your code here
    }
}

package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1834 {
    /*Description
    * 现在有nn个人在排成一排。他们必须从左到右分成连续的mm组。如果每个组的人数都必须大于等于其左边的组的人数，
    * 请问一共有多少种不同的分组方式。对于两个分组而言，顺序不同但组成元素相同的情况被认为是同一种分组。例如[1,2,3]和[1,3,2]是同一个分组。
    * */

    public long groupingOptions(int n, int m) {
        if (n<m)
            return 0;
        long[][] pre = new long[n+1][n+1];
        for (int i=1;i<=n;i++)
            pre[i][i]=1;

        for(int j=2;j<=m;j++){

            long[][] cur=new long[n+1][n+1];
            for(int i=j;i<=n;i++){
                for(int k=1;k<=i-j+1;k++){
                    for(int l=1;l<=k;l++){
                        cur[i][k]+=pre[i-k][l];
                    }
                }
            }
            pre = cur;
        }

        long result = 0;
        for(int i = 1;i<=n;i++)
            result +=pre[n][i];
        return result;
        // write your code here
    }

    public long groupingOptions2(int n, int m) {
        if (n<m)
            return 0;
        long[][][] dp=new long[n+1][m+1][n+2];//其中dp[i][j][k]用来保存i个人j组且最右边的组人数为k的情况数量

        for (int i=1;i<=n;i++){
            dp[i][1][i] = 1;
        }
        for (int i=1; i <=n ;i++) {
            for(int j=2;j<=Math.min(i,m);j++){
                for(int k=1;k<=i-j+1;k++){
                    for(int l=1;l<=k;l++){//倒数第二组的人数
                        dp[i][j][k]+=dp[i-k][j-1][l];
                    }
                }
            }
        }
        long res = 0;
        for(int i=1;i<=n;i++)
            res+= dp[n][m][i];
        return res;
        // write your code here
    }

    private long[][] copy (long[][] pre) {
        long[][] res =new long[pre.length][pre[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++)
                res[i][j] = pre[i][j];
        }
        return res;
    }

    public static void main(String[] args){
        int n = 200, m=148;
        System.out.println(new LINTCODE1834().groupingOptions(n,m));
    }
}

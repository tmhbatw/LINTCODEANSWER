package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1607 {
    /*Description
    * 有 G 名黑帮成员要计划接下来的犯罪活动。
    * 给出两个等长的数组groups 和 profit，它们的含义为第 i 个犯罪需要投入groups[i]个成员，来获得profit[i]的盈利。
    * 一名成员只能同时参加一场犯罪活动。黑帮的目的是至少获得 P 的盈利，你的任务是计算有多少种方案可以选择。
    * 因为答案很大，所以答案要对 10^{9}+71 +7 取模。
    * */

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1000000007;
        int length=group.length;
        int[][][] dp=new int[length+1][G+1][P+1];
        for(int i=0;i<length+1;i++){
            dp[i][0][0]=1;
        }
        for(int i=0;i<length;i++){
            for(int j=0;j<=G;j++){
                for(int k=0;k<=P;k++){
                    dp[i+1][j][k]=dp[i][j][k];
                }
            }
            for(int j=1;j<=G;j++){

                if(j>=group[i]) {
                    for (int k = P; k >=0 ; k--) {
                        dp[i + 1][j][Math.min(P, k + profit[i])] = (dp[i + 1][j][Math.min(P, k + profit[i])] +
                                dp[i][j - group[i]][k]) % mod;
                    }
                }
            }

        }
        int res = 0;
        for(int j=0;j<=G;j++){
            res = (res+dp[length][j][P])%mod;
        }
        return res;
        // Write your code here.
    }
    public static  void main(String[] args){
        int G = 5;
        int P = 0;
        int[] group = new int[]{5};
        int[] profit = new int[]{0};
        System.out.println(new LINTCODE1607().profitableSchemes(G,P,group, profit));
    }
}

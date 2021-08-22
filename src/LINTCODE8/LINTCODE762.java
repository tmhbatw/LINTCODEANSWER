package LINTCODE8;

import java.util.Arrays;

public class LINTCODE762 {
    /*Description
    * 给定两个序列 P 和 Q 。
    * 你可以对这对 P 这个序列修改不超过 k 个元素到任意的值，并要求两个修改后序列的最长公共子序列最长。
    * */

    public int longestCommonSubsequence2(int[] P, int[] Q, int k) {
        int p=P.length,q=Q.length;
        k=Math.min(k,Math.min(q,p));
        int[][][] dp=new int[p+1][q+1][k+1];
        dp[0][0][0]=0;
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                if(P[i]==Q[j]){
                    for(int kk=0;kk<=k;kk++){
                       dp[i+1][j+1][kk]=dp[i][j][kk]+1;
                    }
                }else{
                    dp[i+1][j+1][0]=Math.max(dp[i][j+1][0],dp[i+1][j][0]);
                    for(int kk=1;kk<=k;kk++){
                        dp[i+1][j+1][kk]=Math.max(Math.max(dp[i+1][j][kk],
                                dp[i][j+1][kk]),dp[i][j][kk-1]+1);
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.println(Arrays.toString(dp[i][j])+i+" "+j);
            }
        }
        int result=0;
        for(int kk=0;kk<=k;kk++)
            result=Math.max(result,dp[p][q][kk]);
        return result;
        // Write your code here
    }

    public static void main(String[] args){
        int[] num1=new int[]{1, 2, 3, 4, 5};
        int[] num2=new int[]{5, 3, 1, 4, 2};
        int k=1;
        System.out.println(new LINTCODE762().longestCommonSubsequence2(num1,num2,k));
    }
}

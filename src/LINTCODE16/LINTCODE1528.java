package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1528 {
    /*Description
    * 给定一个严格单调上升的数组position，两个整数m,distance,从position 中选出长度为
    * m的子序列作为A数组 要求：(A[i]−A[i−1])≤distance    1≤i≤m−1
    * 请给出符合条件的方案数量
    * */

    int mod = 99997867;
    public int getnumberschemes(int[] position, int m, int distance) {
        int index=0;
        int length=position.length;
        int[][] dp=new int[length][m+1];
        int[] cur=new int[m+1];
        cur[0]=1;
        for(int i=0;i<length;i++){
            while(position[i]-position[index]>distance){
                for(int j=1;j<=m;j++){
                    cur[j]-=dp[index][j];
                    if(cur[j]<0)
                        cur[j]+=mod;
                }
                index++;
            }
            System.arraycopy(cur, 0, dp[i], 1, m);
            for(int j=0;j<=m;j++){
                cur[j]=(cur[j]+dp[i][j])%mod;
            }
        }
        int result=0;
        for(int i=0;i<length;i++)
            result=(result+dp[i][m])%mod;
        return result;
        // write your code here
    }
}

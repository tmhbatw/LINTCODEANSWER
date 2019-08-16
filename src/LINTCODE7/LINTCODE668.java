package LINTCODE7;

import java.util.Arrays;

public class LINTCODE668 {
    /*Description
    * 在计算机世界中, 由于资源限制, 我们一直想要追求的是产生最大的利益.
    * 现在，假设你分别是 m个 0s 和 n个 1s 的统治者. 另一方面, 有一个只包含 0s 和 1s 的字符串构成的数组.
    * 现在你的任务是找到可以由 m个 0s 和 n个 1s 构成的字符串的最大个数. 每一个 0 和 1 均只能使用一次
    * */

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] num=new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            String cur=strs[i];
            for(int j=0;j<cur.length();j++){
                if(cur.charAt(j)=='0')
                    num[i][0]++;
                else
                    num[i][1]++;
            }
        }
        int[][][] dp=new int[m+1][n+1][strs.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<dp[0][0].length-1;k++){
                    dp[i][j][k+1] = Math.max(i>=num[k][0]&&j>=num[k][1]?dp[i - num[k][0]][j - num[k][1]][k] + 1:0,dp[i][j][k]);
                }
            }
        }
        return dp[m][n][strs.length];
        // write your code here
    }

}

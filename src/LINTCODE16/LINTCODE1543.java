package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1543 {
    /*Description
    * 给两个整数代表网格的高和宽，起点为左上角以及终点为右上角。你可以往右上角、右或者右下角走。求你可以到达终点的路径数。结果需要 mod 1000000007.
    * */

    public int uniquePath(int height, int width) {
        int mod=1000000007;
        int[][] dp=new int[height][width];
        dp[0][0]=1;
        for(int j=1;j<width;j++){
            for(int i=0;i<height;i++){
                if(i==0) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1];
                }
                else if(i==height-1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1])%mod + dp[i + 1][j - 1];
                }
                dp[i][j]%=mod;
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[0][width-1];
        // Write your code here
    }
}

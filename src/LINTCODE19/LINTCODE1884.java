package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1884 {
    /*Description
    * 有一排有编号的瓶子，现在你需要将这些瓶子全部拿走。
    * 你每次只可以拿走连续的若干个瓶子，并且需要保证瓶子的编号是一个“回文串”。
    * 回文串指的是正着和反着读都一样的串，例如“121”和“4664”。
    * 返回拿走所有瓶子所需要的最少次数。
    * */

    public int takeAwayTheBottle(int[] arr) {
        int length=arr.length;
        if(length<=1)
            return length;
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=1;
            if(i>0){
                if(arr[i]==arr[i-1])
                    dp[i-1][i]=1;
                else
                    dp[i-1][i]=2;
            }

        }
        for(int l = 2;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i][j]=dp[i][j-1]+1;
                if(arr[i]==arr[j])
                    dp[i][j]=Math.min(dp[i+1][j-1],dp[i][j]);
                for(int k=i+1;k<j-1;k++){
                    if(arr[k]==arr[j]){
                        dp[i][j]=Math.min(dp[i][k-1]+dp[k+1][j-1],dp[i][j]);
                    }
                }
                if(arr[j-1]==arr[j])
                    dp[i][j]=Math.min(dp[i][j-2]+1,dp[i][j]);
            }
        }
        return dp[0][length-1];
        // Write your code here.
    }
}

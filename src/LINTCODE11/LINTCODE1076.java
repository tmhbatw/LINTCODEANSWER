package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1076 {
    /*Description
    * 给定两个字符串s1，s2，找出最小的需要删除的字符ASCII之和，使得剩余两个字符串相等。
    * */

    public int minimumDeleteSum(String s1, String s2) {
        int s1Length=s1.length();
        int s2Length=s2.length();
        int[][] dp=new int[s1Length+1][s2Length+1];
        for(int i=1;i<=s2Length;i++)
            dp[0][i]=dp[0][i-1]+s2.charAt(i-1);
        for(int i=1;i<=s1Length;i++){
            dp[i][0]=dp[i-1][0]+s1.charAt(i-1);
            for(int j=1;j<=s2Length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j]+s1.charAt(i-1),dp[i][j-1]+s2.charAt(j-1));
            }
        }
        print(dp);
        return dp[s1Length][s2Length];
        // Write your code here
    }

    public static void main(String[] args){
        for(int i=0;i<26;i++){
            System.out.print((char)(i+'a')+" "+(i+'a')+"  ");
        }
    }

    private void print(int[][] dp){
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
    }
}

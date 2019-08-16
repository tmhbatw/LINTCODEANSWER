package LINTCODE7;

public class LINTCODE667 {
    /*Description
    * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
    * */

    public int longestPalindromeSubseq(String s) {
        if(s.length()<=1)
            return s.length();
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=2;
            else
                dp[i][i+1]=1;
        }
        for(int length=2;length<s.length();length++){
            for(int i=0;i<s.length()-length;i++){
                if(s.charAt(i)==s.charAt(i+length)){
                    dp[i][i+length]=dp[i+1][i+length-1]+2;
                }else{
                    dp[i][i+length]=Math.max(dp[i+1][i+length],dp[i][i+length-1]);
                }
            }
        }
        return dp[0][s.length()-1];
        // write your code here
    }
}

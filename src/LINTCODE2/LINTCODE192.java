package LINTCODE2;

public class LINTCODE192 {
    /*Description
    * Implement wildcard pattern matching with support for '?' and '*'.
    * '?' Matches any single character.
    * '*' Matches any sequence of characters (including the empty sequence).
    * The matching should cover the entire input string (not partial).
    * */

    /*Solution
    * 动态规划，创建一个dp数组，其中dp[i][j]用来表示s的前i个字符串和p的前j个字符串是否匹配
    * */
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //判断数组的初始化
        dp[0][0]=true;
        if(p.charAt(0)=='*'){
            dp[0][1]=true;
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*'){
                    dp[i+1][j+1]=dp[i][j]||dp[i][j+1]||dp[i+1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
        // write your code here
    }
}

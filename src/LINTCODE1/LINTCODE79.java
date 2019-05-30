package LINTCODE1;

public class LINTCODE79 {
    /*Description
    * 给出两个字符串，找到最长公共子串，并返回其长度。
    * */

    /*Solution
    * 典型的动态规划问题
    * 比较A的第i个字符与B的第j个字符，若不同则dp[i+1][j+1]=0;
    * 若相同则dp[i+1][j+1]=dp[i][j]+1
    * */

    public int longestCommonSubstring(String A, String B) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        int result=0;
        for(int i=0;i<A.length();i++){
            for(int j=0;j<B.length();j++){
                dp[i+1][j+1]=A.charAt(i)==B.charAt(j)?dp[i][j]+1:0;
                result=Math.max(result,dp[i+1][j+1]);
            }
        }
        return result;
    }
}

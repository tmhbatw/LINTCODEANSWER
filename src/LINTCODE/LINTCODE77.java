package LINTCODE;

public class LINTCODE77 {

    /*Description
    * Given two strings, find the longest common subsequence (LCS).
    * Your code should return the length of LCS.
    * */

    /*Solution
    *典型的动态规划问题
    * 设dp[i][j]表示字符串A从0到i与字符串从0到j的LCS
    * 那么若A.charAt[i+1]==B.charAt[j+1]易知dp[i+1][j+1]=dp[i][j]+1
    * 若A.charAt[i+1]!=B.charAt[j+1]则dp[i+1][j+1]则为dp[i+1][j]与dp[i][j+1]之间的较大值
    * */
    public int longestCommonSubsequence(String A, String B) {
        if(A.length()==0||B.length()==0)
            return 0;
        int[][] result=new int[B.length()+1][A.length()+1];
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                if(A.charAt(i)==B.charAt(j))
                    result[i+1][j+1]=result[i][j]+1;
                else
                    result[i+1][j+1]=Math.max(result[i][j+1],result[i+1][j]);
            }
        }
        return result[B.length()][A.length()];
    }
}

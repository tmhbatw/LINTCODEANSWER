package LINTCODE8;

public class LINTCODE741 {
    /*Description
    *给定一串数字，编写一个函数来计算字符串通过一系列操作能得到的最大值，你可以在任意两个数字之间添加一个加号或乘号。
    * 注意，这题和计算最大值（Calculate Maximum Value）”原题不同，在这题中你可以在任何地方插入括号。
    * */

    public int maxValue(String str) {
        int length=str.length();
        int[][] dp=new int[length][length];
        for(int i=0;i<str.length();i++){
            dp[i][i]=str.charAt(i)-'0';
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int end=i+l;
                for(int j=i;j<end;j++){
                    dp[i][end]=Math.max(dp[i][end],Math.max(dp[i][j]*dp[j+1][end],dp[i][j]+dp[j+1][end]));
                }
            }
        }
        return dp[0][length-1];
        // write your code here
    }
}

package LINTCODE3;

public class LINTCODE200 {
    /*Description
    *Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
    * and there exists one unique longest palindromic substring.
    * */

    /*Solution
    * 首先试一下按长度遍历超时
    * 改用动态规划，创建一个dp[][]数组其中dp[i][j]表示从i到j的字符串是不是一个回文串
    * */

    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int start=0,end=1;
        for(int i=0;i<dp.length;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<dp.length-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                end=i+2;
            }
        }
        for(int len=3;len<=dp.length;len++){
            for(int i=0;i<=dp.length-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1];
                if(dp[i][j]==true){
                    start=i;
                    end=j+1;
                }
            }
        }
        return s.substring(start,end);
        // write your code here
    }

/*    public String longestPalindrome(String s) {
        for(int len=s.length();len>=0;len--){
            for(int i=0;i<=s.length()-len;i++){
                int j=len+i;
                if(isPalin(s.substring(i,j)))
                    return s.substring(i,j);
            }
        }
        return ""+s.charAt(0);

    }        // write your code here

    private static boolean isPalin(String s){
        return new StringBuffer(s).reverse().equals(s);
    }*/
    public static void main(String[] args){
        String s="abc";
        StringBuffer ss=new StringBuffer(s).reverse();
    }
}

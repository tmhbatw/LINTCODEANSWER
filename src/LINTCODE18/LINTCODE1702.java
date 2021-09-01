package LINTCODE18;

public class LINTCODE1702 {
    /*Description
    * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
    * 因为结果可能很大，所以返回取模10^9+7后的答案。
    * */


    public int distinctSubseqII(String S) {
        int length=S.length();
        int[][] dp=new int[length][26];
        dp[0][S.charAt(0)-'a']++;
        int mod=1000000007;
        for(int i=1;i<length;i++){
            int sum=0;
            for(int j=0;j<26;j++){
                sum+=dp[i-1][j];
                sum%=mod;
                dp[i][j]=dp[i-1][j];
            }
            dp[i][S.charAt(i)-'a']=sum+1;
        }
        int sum=0;
        for(int j=0;j<26;j++) {
            sum += dp[length - 1][j];
            sum%=mod;
        }
        return sum;
        // Write your code here
    }

    public static void main(String[] args){
        String test="aaa";
        System.out.println(new LINTCODE1702().distinctSubseqII(test));
    }
}

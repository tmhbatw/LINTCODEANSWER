package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1738 {
    /*Description
    * 我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
    * 有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：
    *
    * 如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
    * 如果 S[i] == 'I'，那么 P[i] < P[i+1]。
    * 有多少个有效排列？因为答案可能很大，模10^9+7以后返回答案。
    * */

    int mod=1000000007;
    public int numPermsDISequence(String S) {
        int n=S.length();
        int[][] dp=new int[n+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            if(S.charAt(i-1)=='D'){
                for(int j=0;j<=i;j++){
                    for(int k=j;k<=i;k++){
                        dp[i][j]+=dp[i-1][k];
                        dp[i][j]%=mod;
                    }
                }
            }else{
                for(int j=0;j<=i;j++){
                    for(int k=0;k<j;k++){
                        dp[i][j]+=dp[i-1][k];
                        dp[i][j]%=mod;
                    }
                }
            }
        }

        for(int[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }

        int cur=0;
        for(int curr:dp[n]){
            cur+=curr;
            cur%=mod;
        }
        return cur;
        // write your code here
    }

    public static void main(String[] args){
        String S="DDID";
        System.out.println(new LINTCODE1738().numPermsDISequence(S));
    }
}

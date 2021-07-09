package LINTCODE12;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LINTCODE1177 {
    /*Description
    *给定一个正整数n，返回所有可能的长度为n的会受到奖励的出勤记录情况。结果可能会很大，请模1000000007（即res = res % 109 + 7)。
    * 学生出勤记录是一个字符串，记录仅由下列三个字符组成：
    * 'A' : 缺席（Absent）.
    * 'L' : 迟到（Late）.
    * 'P' : 到场（Present）.
    * 如果记录包含不超过1个缺席且不超过2个迟到，那么该学生会受到表扬。
    * */

    public int checkRecord(int n) {
        switch (n){
            case 1:
                return 3;
            case 0:
                return 0;
            case 2:
                return 8;
        }
        int mod=1000000007;
        int[][] dp=new int[n][4];//不考虑a的情况。只考虑L的情况 一共三种情况，分别为以P结尾，以PL结尾和以PLL结尾
        dp[0][0]=1;
        dp[0][1]=1;
        dp[0][3]=2;
        dp[1][0]=2;
        dp[1][1]=1;
        dp[1][2]=1;
        dp[1][3]=4;
        dp[2][0]=4;
        dp[2][1]=2;
        dp[2][2]=1;
        dp[2][3]=7;
        for(int i=3;i<n;i++){
            dp[i][0]=dp[i-1][3];
            dp[i][1]=dp[i-2][3];
            dp[i][2]=dp[i-3][3];
            dp[i][3] = ((dp[i][0]+dp[i][1])%mod+dp[i][2])%mod;
        }
        long res=dp[n-1][3];
        res =(res+dp[n-2][3]*2L)%mod;
        for(int i=1;i<n-1;i++){
            res = (res+(long)dp[i-1][3]*dp[n-i-2][3])%mod;
        }
        return (int)res%mod;
        // write your code here
    }

    public static void main(String[] args){
        int n=1000;
        System.out.println(new LINTCODE1177().checkRecord(n));
    }
}

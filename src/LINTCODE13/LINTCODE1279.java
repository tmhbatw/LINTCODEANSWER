package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1279 {
    /*Description
    *给定非负整数n，计算具有不同数字字符的所有整数，其中0 <= x< 10^n
    * */

    int[] dp=new int[]{1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771,8877691};
    public int countNumbersWithUniqueDigits(int n) {
        return n>=10?dp[10]:dp[n];
        // Write your code here
    }

    public static void main(String[] args){
        int[] dp=new int[11];
        dp[0]=1;
        dp[1]=9;
        for(int i=2;i<=10;i++){
            dp[i]=dp[i-1]*(11-i);
        }
        for(int i=1;i<=10;i++){
            dp[i]+=dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
    }
}

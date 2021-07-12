package LINTCODE12;

import LINTCODE11.LINTCODE1083;

import java.util.Arrays;

public class LINTCODE1142 {
    /*Description
    * 给定正整数n，找到小于或等于n的非负整数的个数，要求它们的二进制表示不包含连续的1。
    * */

    public int findIntegers(int num) {
        if(num<=2)
            return num+1;
        if(num<=4)
            return num;
        int cur=num;
        int[][] dp=new int[32][2];
        dp[0][0]=dp[0][1]=1;
        for(int i=1;i<32;i++){
            dp[i][1]=dp[i-1][0];
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
        }
        String s=Integer.toBinaryString(num);
        int length=s.length();
        int res=dp[length-1][0];
        if(s.charAt(1)=='1')
            return res+dp[length-2][0];
        int base=(int)Math.pow(2,length-2);
        return res+findIntegers(num%base);
        // Write your code here
    }
}

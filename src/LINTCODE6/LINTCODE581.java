package LINTCODE6;

import java.util.Arrays;

public class LINTCODE581 {
    /*Description
    * 给出一个字符串，找到最长的重复子序列的长度，并且这两个子序列不能在相同位置有同一元素。
    * 比如：在两个子序列中的第i个元素不能在原来的字符串中有相同的下标。
    * */

    public int longestRepeatingSubsequence(String str) {
        int length=str.length();
        if(length==0)
            return 0;
        int[][] dp=new int[length+1][length+1];
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                if(str.charAt(i)==str.charAt(j))
                    dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i][j]+1);
            }
        }
        return dp[length-1][length];
        // write your code here
    }
    public static void main(String[] args){
        String test="aabb";
        System.out.println(new LINTCODE581().longestRepeatingSubsequence(test));
    }
}

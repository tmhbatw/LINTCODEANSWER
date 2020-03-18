package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1572 {
    /*Description
    * 现在有1个01串str，你的任务是寻找到最长的01连续子串，0和1交替出现，例如010，10101，01。然而，
    * 这对优秀的lintcode的学员来说，有些过于简单了。那么现在，你可以进行一些操作，使得01连续子串尽可能的长。操作是指，你可以选择一个位置，
    * 将字符串断开，变成两个字符串，然后每个字符串翻转，最后按照原来的顺序拼接在一起。你可以进行0次或多次这样的操作，返回你最终能够获得的最大01连续子串的长度。
    * */

    public int askingForTheLongest01Substring(String str) {
        if(str.length()==0)
            return 0;
        int n=str.length();
        str+=str;
        int length=str.length();
        int[] dp=new int[length];
        dp[0]=1;
        int result=0;
        for(int i=1;i<length;i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                dp[i]=dp[i-1]+1;
            }else
                dp[i]=1;
            if(dp[i]>=n)
                return n;
            result=Math.max(result,dp[i]);
        }
        return result;
        // Write your code here
    }
}

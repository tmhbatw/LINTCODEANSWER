package LINTCODE9;

import java.util.Arrays;

public class LINTCODE893 {
    /*Description
    *给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
    * */

    //马拉车算法
    public String longestPalindrome2(String s) {
        int length=s.length();
        char[] c=new char[length*2+3];
        c[0]='/';
        for(int i=0;i<length;i++){
            c[i*2+2]=s.charAt(i);
            c[i*2+1]='*';
        }
        c[2*length+1]='*';
        c[2*length+2]='+';
        int result=0;
        int start=0;
        int maxRight=0;
        int center=0;
        int[] dp=new int[c.length];
        for(int i=1;i<c.length-1;i++){
            if(i>maxRight){
                int l=1;
                while(c[i+l]==c[i-l])
                    l++;
                center=i;
                maxRight=i+l-1;
                dp[i]=maxRight-center+1;
            }else{
                int preIndex=center*2-i;
                if(dp[preIndex]+i-1<maxRight){
                    dp[i]=dp[preIndex];
                }else{
                    int l=maxRight+1-i;
                    while(c[i+l]==c[i-l])
                        l++;
                    center=i;
                    maxRight=i+l-1;
                    dp[i]=maxRight-center+1;
                }
            }
            if(dp[i]-1>result){
                result=dp[i]-1;
                start=(i-result-1)/2;
            }
        }
        return s.substring(start,start+result);
        // write your code here
    }

    public static void main(String[] args){
        String test="aaaaabcba";
        System.out.println(new LINTCODE893().longestPalindrome2(test));
    }
}

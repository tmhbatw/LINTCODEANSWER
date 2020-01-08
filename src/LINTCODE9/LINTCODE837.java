package LINTCODE9;

import java.util.Arrays;

public class LINTCODE837 {
    /*Description
    * 给定一个字符串，你的任务是数出有多少个回文子串在这个字符串内。
    * 一个子串不同于其他的子串，当且仅当开始和结束位置不同。
    * */

    /*Solution
    * dp试一下
    * */

    public int countPalindromicSubstrings(String str) {
        if(str.length()<=1)
            return str.length();
        boolean[][] dp=new boolean[str.length()][str.length()];//用一个Boolean数组用来保存从第i位到第j位
        int res=0; //用来存储满足回文字符串的个数
        for(int i=0;i<str.length();i++) {
            dp[i][i] = true;
            res++;
        }
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt((i+1))){
                dp[i][i+1]=true;
                res++;
            }
        }
        for(int length=2;length<str.length();length++){
            for(int i=0;i<str.length()-length;i++){
                if(str.charAt(i)==str.charAt(i+length)&&dp[i+1][i+length-1]){
                    dp[i][length+i]=true;
                    res++;
                }
            }
        }
        return res;
        // write your code here
    }
}

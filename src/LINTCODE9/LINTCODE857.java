package LINTCODE9;

import java.util.Arrays;

public class LINTCODE857 {
    /*Description
    *给定字符串S和T，在字符串S中找到最小(连续的)子字符串W（窗口），使得T是W的子序列。
    * 如果S中没有包含T中的所有字符的窗口，则返回空字符串""。如果有多个这样的最小长度窗口，则返回一个起点编号最小的。
    * */

    public String minWindow(String S, String T) {
        if(!getMatch(S,T))
            return "";

        int sLength=S.length();
        int tLength=T.length();
        int[][] dp=new int[sLength+1][tLength+1];
        int length=Integer.MAX_VALUE;
        int start=0;

        for(int i=0;i<sLength;i++){
            for(int j=0;j<Math.min(i+1,tLength);j++){
                if(S.charAt(i)==T.charAt(j)){
                    if(dp[i][j]>0||j==0){
                        dp[i+1][j+1]=dp[i][j]+1;
                    }
                }else{
                    if(dp[i][j+1]!=0) {
                        dp[i + 1][j + 1] = dp[i][j + 1] + 1;
                    }
                }

            }

            if(dp[i+1][tLength]!=0&&dp[i+1][tLength]<length){
                length=dp[i+1][tLength];
                start=i+1-length;
            }
        }

        for(int[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }

        System.out.println(start+" "+length);

        return S.substring(start,start+length);
        // Write your code here
    }

    private boolean getMatch(String s,String t){
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(index)){
                index++;
            }
            if(index==t.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        String S = "abcdebdde", T = "bde";
        System.out.println(new LINTCODE857().minWindow(S,T));
    }
}

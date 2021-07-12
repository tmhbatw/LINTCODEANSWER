package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1379 {
    /*Description
    * 一个字符串，每个字符表示一个场景。两个相同字符之间认为是一个连续的场景。
    * 例如: abcda，可以认为这五个字符是同一个场景。
    * 或者acafghbeb可以认为又aca和beb两个场景。场景之间有重合那么就把场景合起来，
    * 例如abcab，这里abca和bcab是重合的，那么认为这五个字符是同一个场景。给一个字符串，求最长场景。
    * */

    public int getLongestScene(String str) {
        int[] start=new int[128];
        Arrays.fill(start,Integer.MAX_VALUE);
        int[] end=new int[128];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            start[c]=Math.min(start[c],i);
            end[c]=i;
        }
        int[] dp=new int[str.length()+1];
        for(int i=0;i<128;i++){
            if(end[i]>start[i]){
                dp[start[i]]+=1;
                dp[end[i]+1]-=1;
            }
        }
        int res=1;
        for(int i=1;i<dp.length;i++){
            dp[i]+=dp[i-1];
        }
        for(int i=0;i<dp.length-1;i++){
            if(dp[i]>0){
                int pre=i;
                while(i<dp.length-1&&dp[i+1]>0)
                    i++;
                res=Math.max(res,i-pre+1);
            }
        }
        return res;
        // Write your code here
    }
}

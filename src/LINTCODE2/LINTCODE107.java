package LINTCODE2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE107 {
    /*Description
    * Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
    * */

    /*Solution
    * 动态规划
    * 需要注意对于算法的优化，注意dict字典中最长字符串的长度
    * S中大于该长度的子字符串一定不存在于字典中
    * */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0)
            return true;
        if(dict.size()==0)
            return false;
        int max=0;
        for(String curr:dict){
            max=Math.max(max,curr.length());
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<dp.length;++i){
            for(int j=Math.max(0,i-max);j<i;j++){
                if(dp[j]==0)
                    continue;
                String curr=s.substring(j,i);
                if(dict.contains(curr)){
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[s.length()]==1;

    }
}

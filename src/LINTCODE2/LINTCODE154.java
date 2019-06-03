package LINTCODE2;

import java.util.Arrays;

public class LINTCODE154 {
    /*Description
    * 实现支持'.'和'*'的正则表达式匹配。
    * '.'匹配任意一个字母。
    * '*'匹配零个或者多个前面的元素。
    * 匹配应该覆盖整个输入字符串，而不仅仅是一部分。
    * 需要实现的函数是：bool isMatch(string s, string p)
    * */

    /*Solution
    * 首先尝试一下递归不好尝试
    * 尝试一下动态规划dp[i][j]表示s的前i个字符串和p的前j个字符串的匹配情况
    * 当s.charAt(i)==p.charAt(j)或者p.charAt(j)=='.'时dp[i][j]=dp[i-1][j-1];
    * 当p.chartAt(j)=='*'时，首先判断p.charAt(j-1)与s.charAt(i)的关系
    * 如果s.charAt(i)不等于p.charAt(j-1)那么说明想要使得dp[i][j]为true，只能使得*匹配0个前一字符，此时dp[i][j]=dp[i][j-2]
    * 如果s.charAt(i)与p.charAt(j-1)相等时，那么可以使得*匹配0次（dp[i][j-2]、匹配1次（dp[i][j-1]、匹配多次（dp[i-1][j])情况中有一种成立即可
    * 返回答案即可
    * */
    public boolean isMatch(String s, String p) {
        if(p.charAt(0)=='*')
            return false;
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        int index=1;
        while(index<p.length()&&p.charAt(index)=='*') {
            dp[0][index+1] = true;
            index=index+2;
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                    dp[i+1][j+1]=dp[i][j];
                }else if(p.charAt(j)=='*'){
                    if((p.charAt(j-1)==s.charAt(i)||p.charAt(j-1) == '.')){
                        dp[i+1][j+1]=dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1];
                    }else if(p.charAt(j-1)!=s.charAt(i))
                        dp[i+1][j+1]=dp[i+1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
        // write your code here
    }

}

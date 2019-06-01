package LINTCODE2;

import java.util.Arrays;

public class LINTCODE118 {
    /*Description
    * 给定字符串 S 和 T, 计算 S 的所有子序列中有多少个 T.
    * 子序列字符串是原始字符串删除一些(或零个)字符之后得到的字符串, 并且要求剩下的字符的相对位置不能改变. (比如 "ACE" 是 ABCDE 的一个子序列, 而 "AEC" 不是)
    * */

    /*Solution
    * 当然可以使用递归回溯但是会超时
    * 动态规划
    * 创建一个动态数组dp[][] 其中dp[i][j]用来保存S字符串的前j个字符组成的字符串中子序列有多少个T中前i个字符
    **可以从中寻找到规律
    * (动态规划找规律）
    * */


    public int numDistinct(String S, String T) {
        int[][]dp=new int[T.length()+1][S.length()+1];
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=1;
        for(int i=0;i<T.length();i++){
            for(int j=i;j<S.length();j++){
                dp[i+1][j+1]=dp[i+1][j]+S.charAt(j)==T.charAt(i)?dp[i][j]:0;
            }
        }
        return dp[T.length()][S.length()];
        // write your code here
    }



    //递归回溯算法
/*    private int result=0;

    public int numDistinct(String S, String T) {
        if(T.length()==0)
            return 1;
        if(S.length()==0)
            return 0;
        recursion(S,T,0,0);
        return result;
        // write your code here
    }

    private void recursion(String S,String T,int s,int t){
        if(t==T.length()){
            result++;
        }

        for(int i=s;i<S.length();i++){
            if(S.charAt(i)==T.charAt(t))
                recursion(S,T,i+1,t+1);
        }
    }*/

}

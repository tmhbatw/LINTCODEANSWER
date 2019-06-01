package LINTCODE2;

public class LINTCODE119 {
    /*Description
    *给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。你总共三种操作方法：
    *   插入一个字符
    *   删除一个字符
    *   替换一个字符
    * */

    /*Solution
    *动态规划，动态规划找规律问题
    * 创建一个动态规划数组dp[i][j];
    * 其中dp[i][j]表示i个字符转化为j个新字符串的最小转化次数
    * 那么dp[i][0]一定为i（唯一可能执行的操作为将i个字符全部删掉）
    * dp[0][j]一定为j(唯一可能执行的操作为添加j个字符）
    * 那么当word1.charAt(i)==word2.charAt(j)时dp[i+1][j+1]=dp[i][j](不用改变）
    * 不相等时dp[i+1][j+1]等于dp[i][j]、dp[i+1][j]、dp[i][j+1]中最小的数加1（分别对应操作转换一个字符、减少一个字符以及增加一个字符）
    * 最后即得到结果
    * */

    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }else{
                    dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
        // write your code here
    }
}

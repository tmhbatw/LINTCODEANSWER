package LINTCODE2;

public class LINTCODE163 {

    /*Description
    *给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？
    * */

    /*Solution
    *这是一个卡塔兰数
    * 可以通过特定的公式求解
    * */


    public int numTrees(int n){
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<n;j++){
                dp[j]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}

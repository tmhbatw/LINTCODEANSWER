package LINTCODE5;

public class LINTCODE440 {
    /*Description
    * 给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
    * 再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?
    * */

    public int backPackIII(int[] A, int[] V, int m) {
        int length=A.length;
        int[] dp=new int[m+1];
        for(int i=0;i<length;i++){
            for(int j=A[i];j<=m;j++){
                dp[j]=Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
        }
        return dp[m];
        // write your code here
    }
}

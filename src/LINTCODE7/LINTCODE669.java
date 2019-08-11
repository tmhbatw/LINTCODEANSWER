package LINTCODE7;

import java.util.Arrays;

public class LINTCODE669 {
    /*Description
    *给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量.
    * 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
    * */

    public static  int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        for(int i=1;i<dp.length;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i<coins[j])
                    break;
                if(dp[i-coins[j]]==Integer.MAX_VALUE)
                    continue;
                dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
        // write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{186,419,83,408};
        int amount=6249;
        System.out.println(coinChange(num,amount));
    }
}

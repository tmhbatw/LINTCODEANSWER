package LINTCODE8;

import java.util.Arrays;

public class LINTCODE740 {
    /*Description
    * 给出不同面值的硬币以及总金额. 试写一函数来计算构成该总额的组合数量. 你可以假设每一种硬币你都有无限个.
    * */

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++){
            if(coins[i]>amount)
                break;
            dp[i+1][coins[i]]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=(j>coins[i-1]?dp[i][j-coins[i-1]]:0)+dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
        // write your code here
    }
}

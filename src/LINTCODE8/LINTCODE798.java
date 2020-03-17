package LINTCODE8;

public class LINTCODE798 {
    /*Description
    *假设你身上有 n 元，超市里有多种大米可以选择，每种大米都是袋装的，必须整袋购买，给出每种大米的重量，价格以及数量，求最多能买多少公斤的大米
    * */

    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        int commodityNumber=prices.length;
        int[][] dp=new int[commodityNumber+1][n+1];
        for(int i=0;i<commodityNumber;i++){
            int singlePrice=prices[i];
            int singleWeight=weight[i];
            for(int number=0;number<=amounts[i];number++) {
                int price=singlePrice*number;
                for (int j = 1; j <= n; j++) {
                    if(j>=price){
                        dp[i+1][j]=Math.max(dp[i+1][j],singleWeight*number+dp[i][j-price]);
                    }
                }
            }
        }
        return dp[commodityNumber][n];
        // write your code here
    }
}

package LINTCODE9;

import java.util.Arrays;

public class LINTCODE800 {
    /*Description
    *你总共有n 万元，希望申请国外的大学，要申请的话需要交一定的申请费用，给出每个大学的申请费用以及你得到这个大学offer的成功概率，
    * 大学的数量是 m。如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
    * */

    public double backpackIX(int n, int[] prices, double[] probability) {
        double[] dp=new double[n+1];
        Arrays.fill(dp,1.0);
        for(int i=0;i<probability.length;i++){
            probability[i]=1-probability[i];
        }
        for(int i=0;i<prices.length;i++){
            int curPrice=prices[i];
            for(int j=n;j>=1;j--){
                if(j>=curPrice){
                    dp[j]=Math.min(dp[j-curPrice]*probability[i],dp[j]);
                }
            }
        }
        return 1-dp[n];
        // write your code here
    }
}

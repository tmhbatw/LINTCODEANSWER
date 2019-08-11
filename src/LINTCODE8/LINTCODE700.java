package LINTCODE8;

public class LINTCODE700 {
    /*Description
    * 给一个 n 英寸长的杆子和一个包含所有小于 n 的尺寸的价格. 确定通过切割杆并销售碎片可获得的最大值.
    * */

    public int cutting(int[] prices, int n) {
        int[] dp=new int[n+1] ;
        for(int i=1;i<dp.length;i++){
            dp[i]=prices[i-1];
            for(int j=0;j<=i/2;j++){
                dp[i]=Math.max(dp[j]+dp[i-j],dp[i]);
            }
        }
        return dp[n];
        // Write your code here
    }
}

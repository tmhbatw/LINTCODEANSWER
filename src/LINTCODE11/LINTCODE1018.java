package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1018 {
    /*Description
    * 我们将玻璃杯按照金字塔的方式摆放，其中第一行有1个玻璃杯，第二行有2个玻璃杯，第三行有3个玻璃杯，
    * 依此类推直到第100行。 每个杯子可以装一杯（250毫升）香槟。
    * 然后，从顶部的第一个玻璃杯中开始倒入香槟。 当最顶部的玻璃杯已满时，任何多余的液体将立即等量地流到玻璃杯的左右两侧。
    * 当第二行玻璃杯变满时，任何多余的香槟都会同样流到这些玻璃杯的左右两侧，依此类推（最底部的玻璃杯倒满后多余的液体会流到地面上）。
    * 例如，在倒入一杯香槟后，最顶部的玻璃杯已满。 倒两杯香槟后，第二排的两个杯子都是半满的。 在倒了三杯香槟之后，这两个杯子变满了 - 现在共有3个全杯。
    * */

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[100][100];
        dp[0][0]=poured;
        for(int i=0;i<99;i++){
            for(int j=0;j<=i;j++){
                double cur=dp[i][j]-1<0?dp[i][j]:0;
                dp[i+1][j]+=cur/2;
                dp[i+1][j+1]+=cur/2;
            }
        }
        for(double[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }
        return dp[query_row][query_glass]>1?1:dp[query_row][query_glass];
        // write your code here
    }
}

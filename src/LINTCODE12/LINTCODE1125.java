package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1125 {
    /*Description
    * 小易有n根柱子，第i根柱子的高度为
    * */

    public boolean jumpPillar(int[] h, int k) {
        int length=h.length;
        int[] dp=new int[length];
        dp[0]=1;
        for(int i=1;i<length;i++){
            for(int j=Math.max(0,i-k);j<i;j++){
                if(dp[j]==1&&dp[j]>dp[i]){
                    dp[i]=1;
                    break;
                }
            }
            if(dp[i]==1)
                continue;
            for(int j=Math.max(0,i-k);j<i;j++){
                if(dp[j]==2&&dp[j]>dp[i]||dp[j]==1){
                    dp[i]=2;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[length-1]>0;
        // write your code here.
    }
}

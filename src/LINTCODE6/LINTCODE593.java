package LINTCODE6;

import java.util.Arrays;

public class LINTCODE593 {
    /*Description
    * 有一个石头游戏。在游戏的开始的时候，玩家在 圈 中挑选了n堆石头。
    * 目标是按照下面的规则将石头合并成一堆：
    * 在游戏中的每一步，玩家可以合并两堆相邻的石头为新的一堆石头。分数就是新的石头堆的石头个数。你需要找到最小的总分。
    * */

    public int stoneGame2(int[] A) {
        if(A==null||A.length==0)
            return 0;
        int length=A.length;
        int[] a=new int[length*2];
        int[] sum=new int[length*2+1];
        int[][] dp=new int[length*2][length*2];
        for(int i=0;i<length;i++){
            a[i]=a[i+length]=dp[i][i]=dp[i+length][i+length]=A[i];
            sum[i+1]=sum[i]+A[i];
        }
        for(int i=0;i<length;i++)
            sum[i+length+1]=sum[i+length]+A[i];
        for(int l=1;l<length;l++){
            for(int i=0;i<length*2-l;i++){
                int end=i+l;
                dp[i][end]=dp[i][i]+dp[i+1][end]+sum[end+1]-sum[i];
                for(int j=i+1;j<end;j++){
                    dp[i][end]=Math.min(dp[i][end],dp[i][j]+dp[j+1][end]+sum[end+1]-sum[i]);
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<length;i++)
            result=Math.min(result,dp[i][i+length-1]);
        return result-sum[length];
        // write your code here
    }

/*    public int stoneGame2(int[] A) {
        if(A==null||A.length==0)
            return 0;
        int length=A.length;
        int[][] dp=new int[length][length];
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++){
            sum[i+1]=sum[i]+A[i];
            dp[i][i]=A[i];
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int end=i+l;
                dp[i][end]=dp[i][i]+dp[i+1][end]+sum[end+1]-sum[i];
                for(int j=i+1;j<end;j++){
                    dp[i][end]=Math.min(dp[i][end],dp[i][j]+dp[j+1][end]+sum[end+1]-sum[i]);
                }
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[0][length-1]-sum[length];

        // write your code here
    }*/

    public static void main(String[] args){
        int[] result=new int[]{1,10,11,12,15,16,19,4,5,9,7};
    }
}

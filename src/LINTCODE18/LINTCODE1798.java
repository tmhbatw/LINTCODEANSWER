package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1798 {
    /*Description
    * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
    * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
    * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
    * */

    public int mergeStones(int[] stones, int K) {
        int length=stones.length;
        if((stones.length-1)%(K-1)!=0)
            return -1;

        //dp数组表示从i到j合并成k堆的最小成本
        int[][][] dp=new int[length][length][K+1];

        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+stones[i];

        System.out.println(Arrays.toString(sum));

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                for(int k=0;k<=K;k++)
                    dp[i][j][k]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<length;i++)
            dp[i][i][1]=0;

        for(int l=1;l<length;l++){

            for(int i=0;i<length-l;i++){
                int j=i+l;

                for(int k=2;k<=K;k++){
                    for(int m=i;m<j;m+=K-1){

                        //证明这种情况不存在
                        if(dp[m+1][j][k-1]==Integer.MAX_VALUE||dp[i][m][1]==Integer.MAX_VALUE)
                            continue;

                        dp[i][j][k]=Math.min(dp[i][j][k],dp[i][m][1]+dp[m+1][j][k-1]);
                    }
                }

                if(dp[i][j][K]!= Integer.MAX_VALUE) {
                    dp[i][j][1] = dp[i][j][K]+sum[j+1]-sum[i];
                }

            }

        }

        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                System.out.println(i+" "+j+" "+ Arrays.toString(dp[i][j]));
            }
        }
        return dp[0][length-1][1];
        // write your code here
    }


    public static void main(String[] args){
        int[] num=new int[]{6, 7, 4, 7, 5, 9, 8};
        int k=4;
        System.out.println(new LINTCODE1798().mergeStones(num,k));
    }
}

package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE89 {
    /*Description
    *Given n distinct positive integers, integer k (k <= n) and a number target.
    * Find k numbers where sum is target. Calculate how many solutions there are?
    * */

    /*Solution
    * 递归思路与第90题思路完全相同，只不过返回一个数值而已，但是会超时
    * 可以使用动态规划
    * dp[i][m][n]表示当从i个数取m个和为n的种类数量
    *那么易知当i为任何数，取0个数，和为0的情况有1种
    * 且动态方程为d[i][m][n]=d[i-1][m][n]+d[i-1][m-1][n-A[i]];
    * */
    public int kSum(int[] A, int k, int target) {

       int[][][] dp=new int[A.length+1][k+1][target+1];
        for(int i=0;i<A.length;i++){
                dp[0][0][0]=1;
        }
        dp[1][1][A[0]]=1;
       for(int i=0;i<A.length;i++){
           for(int m=0;m<k;m++){
               for(int n=0;n<target;n++)
                   dp[i+1][m+1][n+1]=(n+1-A[i]>=0)?dp[i][m][n+1-A[i]]+dp[i][m+1][n+1]:dp[i][m+1][n+1];
           }
       }
        return dp[A.length][k][target];
    }

    public static void main(String[] args){
        int[] i=new int[3];
        System.out.println(Arrays.toString(i));
    }



}

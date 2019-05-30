package LINTCODE1;

import java.util.List;

public class LINTCODE91 {


    /*Description
    *Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
    * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
    * */

    /*Solution
    * 动态规划，创建一个dp数组其中dp[i][j]表示第i个数调整到j时，需要的代价是多少
    * 因为每个数小于等于100，那么j最大为100
    * 因为要使得dp[i][j]满足题目要求，那么第i-1个数必须调整为j+target与j-target之间
    * 用动态规划数组表示即为dp[i-1][j-target]到dp[i-1][j+target]中最小的那个值加上第i个数到j的代价即为dp[i][j]的值
    * */

    public int MinAdjustmentCost(List<Integer> A, int target) {
        int[][] dp=new int[A.size()][101];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<100;j++){
                int last=Integer.MAX_VALUE;
                int left=Math.max(1,j+1-target);
                int right=Math.min(100,j+1+target);
                for(int k=left;k<=right;k++){
                    last=Math.min(dp[i][k],last);
                }
                dp[i+1][j+1]=Math.abs(j+1-A.get(i))+last;
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<100;i++){
            result=Math.min(result,dp[A.size()][i+1]);
        }
        return result;
        // write your code here
    }
}

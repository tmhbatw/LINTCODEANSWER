package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1083 {

    /*Description
    * 在给定的正整数数组nums中，找到三个非重叠子数组的最大和。
    * 每个子数组的大小为“k”，我们希望最大化所有“3 * k”条目的总和。
    * 将结果以每个区间（子数组）的起始位置的索引的列表返回，（从0开始索引）。 如果有多个答案，请返回按字典顺序排列的最小答案。
    * */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length=nums.length;
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+nums[i];
        int[][] dp=new int[length+1][4];
        int[][][] res=new int[length+1][4][3];
        for(int time=1;time<=3;time++){
            int start=time*k-1;
            for(int i=start;i<length;i++){
                int curSum = sum[i+1]-sum[i+1-k]+dp[i+1-k][time-1];
                if(curSum>dp[i][time]){
                    dp[i+1][time] = curSum;
                    res[i+1][time]=res[i+1-k][time-1].clone();
                    res[i+1][time][time-1] = i-k+1;
                }else{
                    dp[i+1][time]=dp[i][time];
                    res[i+1][time]=res[i][time].clone();

                }
            }
        }
        return res[length][3];
        // Write your code here
    }
}

package LINTCODE6;

import java.util.Arrays;

public class LINTCODE563 {
    /*Description
    * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
    * 每一个物品只能使用一次
    * */

    /*Solution
    *依然是一个动态规划不过与上一题要求略有不同
    * */

    public int backPackV(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        int[][] dp=new int[nums.length][target+1];
        Arrays.sort(nums);
        if(nums[0]>target)
            return 0;
        dp[0][0]=1;
        dp[0][nums[0]]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<target+1;j++){
                if(j<nums[i])
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
        // write your code here
    }
}

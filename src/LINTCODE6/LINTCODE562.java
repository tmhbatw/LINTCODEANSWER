package LINTCODE6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LINTCODE562 {

    /*Description
    * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小,
    * 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
    * */

    /*Solution
    * 动态规划
    * 需要创建一个二维数组
    * */

    public int backPackIV(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int[][] dp=new int[nums.length][target+1];
        //对第一列数字进行赋值
        for(int i=0;i<dp[0].length;i++){
            if(i%nums[0]==0)
                dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j<nums[i])
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
        // write your code here
    }

}

package LINTCODE7;

import java.util.Arrays;

public class LINTCODE670 {
    /*Description
    *给一由非负整数构成的分数数组. 玩家1 从数组的任意一端选择一个数字, 然后是玩家2, 然后又是玩家1 等等.
    * 每一次一个玩家都只取一个数, 每个数只能取一次. 等到数组内分数都被取完后, 分数大的那个玩家获胜.
    * 给一分数数组, 预测玩家1 是否是赢家.你可以假设每个玩家都想要使他的分数尽可能的大.
    * */

    public boolean PredictTheWinner(int[] nums) {
        if(nums.length<=2)
            return false;
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            dp[i][i+1]=Math.max(nums[i],nums[i+1]);
        }
        for(int length=2;length<nums.length;length++){
            for(int i=0;i<nums.length-length;i++){
                dp[i][i+length]=Math.max(nums[i]+Math.min(dp[i+2][i+length],dp[i+1][i+length-1]),nums[i+length]+Math.min(dp[i][i+length-2],dp[i+1][i+length-1]));
            }
        }
        for(int[] cur:dp) {
            System.out.println(Arrays.toString(cur));
        }
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(dp[0][nums.length-1]*2>=sum)
            return true;
        return false;
        // write your code here
    }
}

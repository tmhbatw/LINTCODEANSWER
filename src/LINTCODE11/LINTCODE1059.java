package LINTCODE11;

public class LINTCODE1059 {
    /*Description
    * 给定一个整数数组，你可以在这个数组上进行操作。
    * 在每次操作中，你可以选择任意数num[i]并且删除它从而得到num[i]的分数。在此之后，你必须删除掉任何和num[i]-1或者num[i]+1相等的元素。
    * 你将从0分开始。返回你通过这些操作可以获得的最大的分数。
    * */

    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int cur:nums)
            max=Math.max(max,cur);
        if(max==0)
            return 0;
        int[] dp=new int[max+1];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]+=nums[i];
        }
        for(int i=2;i<=max;i++)
            dp[i]=Math.max(dp[i-1],dp[i-2]+dp[i]);
        return dp[max];
        // write your code here
    }
}

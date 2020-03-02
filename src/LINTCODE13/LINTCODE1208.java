package LINTCODE13;

public class LINTCODE1208 {
    /*Description
    * 给定一个非负整数的列表a1,a2,...an，再给定一个目标S。现在用+和-两种运算，对于每一个整数，选择一个作为它前面的符号。
    * 找出有多少种方法，使得这些整数的和正好等于S。
    * */

    int result=0;
    public int findTargetSumWays(int[] nums, int s) {
        recursion(nums,0,s,0);
        return result;
        // Write your code here
    }

    private void recursion(int[] nums,int time,int target,int curSum){
        if(time==nums.length){
            if(curSum==target)
                result++;
            return;
        }
        recursion(nums,time+1,target,curSum+nums[time]);
        recursion(nums,time+1,target,curSum-nums[time]);
    }
}

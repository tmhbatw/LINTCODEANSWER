package LINTCODE7;

public class LINTCODE620 {
    /*Description
    * 给定一个整数数组，找到长度大于或等于 k 的连续子序列使它们的和最大，返回这个最大的和，如果数组中少于k个元素则返回 0
    * */

    public int maxSubarray4(int[] nums, int k) {
        if(nums==null||nums.length<k)
            return 0;
        int curSum=0;
        for(int i=0;i<k;++i){
            curSum+=nums[i];
        }
        int result=curSum;
        int preSum=0;
        int min=0;
        for(int i=k;i<nums.length;++i){
            curSum+=nums[i];
            preSum+=nums[i-k];
            min=Math.min(min,preSum);
            result=Math.max(result,curSum-min);
        }
        return result;
        // write your code here
    }
}

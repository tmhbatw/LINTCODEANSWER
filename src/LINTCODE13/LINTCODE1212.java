package LINTCODE13;

public class LINTCODE1212 {
    /*Description
    * 给定一个二进制数组，找出该数组中最大连续1的个数。
    * */

    public int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                max = Math.max(curSum, max);
                curSum=0;
            }else
                curSum++;
        }
        return Math.max(curSum,max);
        // Write your code here
    }
}

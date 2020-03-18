package LINTCODE6;

import java.util.Arrays;

public class LINTCODE533 {
    /*Description
    * 给定整数数组num，从中找到两个数字使得他们和最接近target，返回两数和与 target 的差的 绝对值。
    * */

    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int result=Integer.MAX_VALUE;
        while(left<right){
            int curSum=nums[left]+nums[right];
            if(curSum==target)
                return 0;
            else if(curSum<target){
                result=Math.min(target-curSum,result);
                left++;
            }else{
                result=Math.min(result,curSum-target);
                right--;
            }
        }
        return result;
        // write your code here
    }
}

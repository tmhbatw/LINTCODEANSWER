package LINTCODE4;

import java.util.Arrays;

public class LINTCODE304 {
    /*Description
    * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大
    * */

    public long MaximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        long result1=1;
        result1*=nums[length-1];
        result1*=nums[length-2];
        result1*=nums[length-3];
        long result2=1;
        result2*=nums[0];
        result2*=nums[1];
        result2*=nums[length-1];
        return Math.max(result1,result2);
        // write your code here
    }
}

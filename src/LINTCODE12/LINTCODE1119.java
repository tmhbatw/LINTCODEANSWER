package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1119 {
    /*Description
    * 给定一个整数数组，找到三个元素，使乘积最大，返回该积。
    * */

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length-1;
        int max1=nums[length]*nums[length-1]*nums[length-1];
        int max2=nums[length]*nums[0]*nums[1];
        return Math.max(max1,max2);
        // Write your code here
    }
}

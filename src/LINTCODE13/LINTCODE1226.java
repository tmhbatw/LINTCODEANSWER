package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1226 {
    /*Description
    *给定一个非空的整数数组，找出使得数组中所有元素相同的最少步数，其中一步被定义为将数组内任一元素加一或减一。
    * 数组中最多包含10,000个元素。
    * */

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=0;
        int length=nums.length;
        if(length%2==0)
            mid=(nums[length/2]+nums[length/2-1])/2;
        else
            mid=nums[length/2];
        int result=0;
        for(int cur:nums)
            result+=Math.abs(cur-mid);
        return result;
        // Write your code here
    }
}

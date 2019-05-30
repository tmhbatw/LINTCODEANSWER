package LINTCODE1;

import java.util.Arrays;

public class LINTCODE80 {
    /*Description
    *Given a unsorted array with integers, find the median of it.
    * A median is the middle number of the array after it is sorted.
    * If there are even numbers in the array, return the N/2-th number after sorted.
    * */

    /*Solution
    * 先排序后输出
    * */
    public int median(int[] nums) {
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int length=nums.length;
        if(length%2==0)
            return nums[length/2];
        else
            return(nums[length/2]+nums[length-1])/2;
        // write your code here
    }

}

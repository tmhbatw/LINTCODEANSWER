package LINTCODE6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE587 {
    /*Description
    * 给一整数数组, 找到数组中有多少组 不同的元素对 有相同的和, 且和为给出的 target 值, 返回对数.
    * */

    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int result=0;
        while(left<right){
            if(nums[left]+nums[right]<target) {
                left++;
                continue;
            }
            if(nums[left]+nums[right]>target) {
                right--;
                continue;
            }
            result++;
            while(left<right&&nums[left+1]==nums[left])
                left++;
            while(right>left&&nums[right-1]==nums[right])
                right--;
            left++;
            right--;
        }
        return result;
        // write your code here
    }
}

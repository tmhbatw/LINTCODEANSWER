package LINTCODE7;

import java.util.Arrays;

public class LINTCODE609 {
    /*Description
    * 给定一个整数数组，找出这个数组中有多少对的和是小于或等于目标值。返回对数。
    * */

    public int twoSum5(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=0;i<length-1;i++){
            if(nums[i]+nums[i+1]>target)
                return result;
            int curTarget=target-nums[i];
            int left=i+1,right=length-1;
            int mid=left;
            while(left<=right){
                mid=left+(right-left)/2;

                if(nums[mid]<=curTarget&&(mid==length-1||nums[mid+1]>curTarget))
                    break;
                if(nums[mid]>curTarget)
                    right=mid-1;
                else
                    left=mid+1;
            }
            result+=mid-i;
        }
        return result;
        // write your code here
    }
}

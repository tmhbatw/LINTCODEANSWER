package LINTCODE5;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE443 {
    /*Description
    *给一组整数，问能找出多少对整数，他们的和大于一个给定的目标值。
    * */

    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=length-1;i>=1;i--){
            if(nums[i]+nums[i-1]<=target)
                break;
            int left=0,right=i-1;
            int mid=0;
            int curTarget=target-nums[i];
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]>curTarget&&(mid==0||nums[mid-1]<=curTarget))
                    break;
                if(nums[mid]<=curTarget)
                    left=mid+1;
                else
                    right=mid-1;
            }
            result+=i-mid;
        }
        return result;
        // write your code here
    }
}

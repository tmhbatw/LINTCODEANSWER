package LINTCODE10;

import java.util.Arrays;

public class LINTCODE918 {
    /*Description
    * 给定一个n个整数的数组和一个目标整数target，找到下标为i、j、k的数组元素
    * 0 <= i < j < k < n，满足条件nums[i] + nums[j] + nums[k] < target.
    * */

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            int curTarget=target-nums[i];
            int left=i+1,right=length-1;
            while(left<right){
                if(nums[left]+nums[right]<curTarget){
                    result+=right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
        // Write your code here
    }
}

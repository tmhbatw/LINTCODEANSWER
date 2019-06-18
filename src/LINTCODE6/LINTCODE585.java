package LINTCODE6;

public class LINTCODE585 {

    /*Description
    *给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）
    * */

    /*Solution
    * 二分法
    * */

    public int mountainSequence(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1||nums[0]>nums[1])
            return nums[0];
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>nums[mid-1]){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return nums[left];
        // write your code here
    }
}

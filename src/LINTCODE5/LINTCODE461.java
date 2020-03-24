package LINTCODE5;

import java.util.Arrays;

public class LINTCODE461 {
    /*Description
    * 找到一个无序数组中第K小的数
    * */

    public int kthSmallest(int k, int[] nums) {
        return getRes(0,nums.length-1,k-1,nums);
        // write your code here
    }

    private int getRes(int start,int end,int k,int[] nums){
        int cur=nums[start];
        int left=start+1;
        int right=end;
        while(left<right){
            if(nums[left]<cur){
                left++;
                continue;
            }
            if(nums[right]>=cur){
                right--;
                continue;
            }
            swap(nums,left,right);
            left++;
            right--;
        }
        if(left==nums.length||nums[left]>=cur)
            left--;
        if(left==k)
            return cur;
        swap(nums,start,left);
        if(left<k)
            return getRes(left+1,end,k,nums);
        return getRes(start,left-1,k,nums);
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }


}

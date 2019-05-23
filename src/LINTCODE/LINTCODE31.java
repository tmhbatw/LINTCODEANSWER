package LINTCODE;

public class LINTCODE31 {
    /*Description
    *Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
    * .All elements < k are moved to the left
    * .All elements >= k are moved to the right
    * Return the partitioning index, i.e the first index i nums[i] >= k.
    * */

    /*Solution
    * 快速排序方法的第一步即可
    * 创建一个左下标left与右下标right，当nums[left]>k且nums[right]<k时交换左右两边数字
    * 超越100%方法
    * */

    public int partitionArray(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            //获取左边的大于等于k的数的下标
            if(nums[left]<k){
                left++;
                continue;
            }
            //获取右边的小于k的数的下标
            if(nums[right]>=k){
                right--;
                continue;
            }
            //当找到时左右两个数交换位置
            swap(nums,left,right);
        }
        return left;
        // write your code here
    }
    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

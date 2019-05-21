package LINTCODE;

public class LINTCODE14 {
    /*Description
    * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
    * If the target number does not exist in the array, return -1.
    * */

    /*Solution
    * 最基础的二分查找法
    * 因为要寻找最先出现的位置，需要进行当前数字与前一个数字进行大小判别
    * 需要小心数组不存在目标值的情况
    * */


    public int binarySearch(int[] nums, int target) {
        //排除了数组中不存在目标值以及目标值为数组第一位的情况
        if(nums[0]>target||nums[nums.length-1]<target)
            return -1;
        if(nums[0]==target)
            return 0;
        return Search(nums,target,0,nums.length);
        // write your code here
    }

    private int Search(int[] nums,int target,int left,int right){
        if(left==right){
            if(nums[left]==target)
                return left;
            else
                return -1;
        }
        int mid=(left+right)/2+1;
        if(nums[mid]==target&&nums[mid-1]<nums[mid])
            return mid;
        else if(nums[mid]<target){
            return Search(nums,target,mid+1,right);
        }else{
            return Search(nums,target,left,mid-1);
        }
    }
}

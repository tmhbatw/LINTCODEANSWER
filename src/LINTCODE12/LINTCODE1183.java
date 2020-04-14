package LINTCODE12;

public class LINTCODE1183 {
    /*Description
    *给定一个排序数组，只包含整数，其中每个元素出现两次，除了一个出现一次的元素。 找到只出现一次的单个元素。
    * */

    public int singleNonDuplicate(int[] nums) {
        int length=nums.length;
        int left=0,right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==0&&nums[mid]!=nums[mid+1]||mid==length-1&&nums[mid]!=nums[mid-1]||nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1])
                return nums[mid];
            if(mid==length-1||mid%2==0&&nums[mid+1]>nums[mid]||mid%2==1&&nums[mid]>nums[mid-1])
                right=mid-1;
            else
                left=mid+1;
        }
        return nums[left];
        // write your code here
    }
}

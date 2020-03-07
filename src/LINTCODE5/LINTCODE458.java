package LINTCODE5;

public class LINTCODE458 {
    /*Description
    *给一个升序数组，找到 target 最后一次出现的位置，如果没出现过返回 -1
    * */

    public int lastPosition(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==nums.length-1&&nums[mid]==target||mid<nums.length-1&&nums[mid]==target&&nums[mid+1]>target)
                return mid;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
        // write your code here
    }
}

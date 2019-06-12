package LINTCODE5;

public class LINTCODE457 {

    /*Description
    *在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回 -1。
    * */

    /*Solution
    * 二分法查询
    * */

    public int findPosition(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                i=mid+1;
            else
                j=mid-1;
        }
        return -1;
        // write your code here
    }

}

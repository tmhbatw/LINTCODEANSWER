package LINTCODE2;

public class LINTCODE159 {
    /*Description
    * 假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。你需要找到其中最小的元素。
    * */

    /*Solution
    *二分法，定位找到最大的数字，返回其后一个即可
    * */

    public int findMin(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            int mid=i+(j-i+1)/2;
            if(nums[mid]>=nums[0]){
                i=mid;
            }else{
                j=mid-1;
            }
        }
        j=j==nums.length-1?0:j+1;
        return nums[j];
        // write your code here
    }
}

package LINTCODE2;

public class LINTCODE160 {
    /*Description
    *Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    * */

    /*Solution
    * 与上一题思路基本相同，只是当开始数字与最后数字相等时会影响判断，因此将前面与最后一个数字相等的数++
    * 然后与上一题进行相同操作即可
    * */
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int temp=nums[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==temp)
                nums[i]++;
            else{
                break;
            }
        }
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

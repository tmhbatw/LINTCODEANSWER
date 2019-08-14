package LINTCODE8;

public class LINTCODE767 {
    /*Description
    * 原地翻转给出的数组 nums
    * */

    public void reverseArray(int[] nums) {
        for(int i=0;i<nums.length/2;i++){
            int temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
        // write your code here
    }
}

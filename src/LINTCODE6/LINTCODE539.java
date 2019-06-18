package LINTCODE6;

public class LINTCODE539 {
    /*Description
    *给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
    * */

    /*Solution
    * 使用双指针操作
    * */

    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=0;
                nums[j++]=temp;

            }
        }
        // write your code here
    }
}

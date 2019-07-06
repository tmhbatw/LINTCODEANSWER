package LINTCODE6;

public class LINTCODE507 {
    /*Description
    * Given an unsorted array nums, reorder it such that
    * nums[0] < nums[1] > nums[2] < nums[3]....
    * */
    /*Solution
    * 与508题相同
    * */

    public void wiggleSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if((i&1)==1){
                if(nums[i]<nums[i-1]){
                    int temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                }
            }
            else{
                if(nums[i]>nums[i-1]){
                    int temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                }
            }
        }
        // write your code here
    }
}

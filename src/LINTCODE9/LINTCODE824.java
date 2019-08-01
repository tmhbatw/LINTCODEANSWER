package LINTCODE9;

public class LINTCODE824 {
    /*Description
    *给定数组，除了一个数出现一次外，所有数都出现两次，
    * 并且所有出现两次的数都挨着。请找出找出那个出现一次的数。
    * */

    public int getSingleNumber(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0) {
                count=1;
            }else if(count==1){
                if(nums[i]!=nums[i-1])
                    return nums[i-1];
                count=0;
            }
        }
        return nums[nums.length-1];
        // Write your code here
    }
}

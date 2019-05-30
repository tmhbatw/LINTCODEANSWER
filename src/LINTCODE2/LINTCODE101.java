package LINTCODE2;

public class LINTCODE101 {
    /*Description
    *Given a sorted array, remove the duplicates in place such that each element appear at most twice and return the new length.
    * If a number appears more than two times, then keep the number appears twice in array after remove.
    * */

    /*Solution
    * 解决思路与101题基本相同，只不过保留两个相同的数即可
    *
    * */

    public int removeDuplicates(int[] nums) {
        if(nums.length<=2)
            return 2;
        int j=0,i=0;
        for(;i<nums.length-2;i++){
            if(nums[i]==nums[i+1]&&nums[i]==nums[i+2])
                continue;
            nums[j++]=nums[i];
        }
        nums[j++]=nums[i++];
        nums[j++]=nums[i++];
        return j;
        // write your code here
    }
}

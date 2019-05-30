package LINTCODE2;

public class LINTCODE100 {

    /*Description
    *Given a sorted array, 'remove' the duplicates in place such that each element appear only once and return the 'new' length.
    * Do not allocate extra space for another array, you must do this in place with constant memory.
    * */

    /*Solution
    * 使用快慢两个指针
    * 快指针用来遍历数组，慢指针用来将不重复的数字保存在数组中
    * */

    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++ ){
            if(i!=nums.length-1&&nums[i]==nums[i+1])
                continue;
            nums[j++]=nums[i];

        }
        return j;
        // write your code here
    }

}

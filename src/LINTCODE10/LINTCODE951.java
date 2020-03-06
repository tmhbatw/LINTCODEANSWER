package LINTCODE10;

import java.util.Arrays;

public class LINTCODE951 {
    /*Description
    * 给一列数组要求重排，必须所有偶数位上的数都小于所有奇数位上的数。同时，偶数位上的数也按照升序排序，奇数位上的也按照升序排序。
    * */

    public int[] rearrange(int[] nums) {
        Arrays.sort(nums);
        int[] result=new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(index>=nums.length)
                index=1;
            result[index]=nums[i];
            index+=2;
        }
        return result;
        // Write your code here
    }
}

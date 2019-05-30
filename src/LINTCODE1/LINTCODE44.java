package LINTCODE1;

import java.util.List;

public class LINTCODE44 {
    /*Description
    * Given an array of integers, find the subarray with smallest sum.
    * Return the sum of the subarray.
    * */

    /*Solution
    * 解决思路与41相似，只不过具体操作与41题相反
    * */

    public int minSubArray(List<Integer> nums) {
        int min=nums.get(0);
        int[] result=new int[nums.size()];
        result[0]=nums.get(0);
        for(int i=1;i<nums.size();i++){
            result[i]=result[i-1]<0?result[i-1]+nums.get(i):nums.get(i);
            min=Math.min(min,result[i]);
        }
        return min;
        // write your code here
    }

}

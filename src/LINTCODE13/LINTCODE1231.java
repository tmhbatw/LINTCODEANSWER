package LINTCODE13;

public class LINTCODE1231 {
    /*Description
    *给定一个大小为n的非空整数数组，找出使得数组中所有元素相同的最少步数，
    * 其中一步被定义为将数组中n - 1个元素加一。
    * */

    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        int result=0;
        for(int i=0;i<nums.length;i++)
            result+=nums[i]-min;
        return result;
        // Write your code here
    }
}

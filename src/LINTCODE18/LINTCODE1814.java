package LINTCODE18;

public class LINTCODE1814 {
    /*Description
    * 给定一个数组nums, 你需要返回这个数组所有子数组之和。
    * */

    /*Solution
    * 出现的次数恰好等于左边数字数加1与右边数字加1之积
    * */

    public int SubArraySum(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=nums[i]*(i+1)*(nums.length-i);
        }
        return res;
        // write your code here
    }
}

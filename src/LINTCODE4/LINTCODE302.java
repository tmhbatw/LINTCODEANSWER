package LINTCODE4;

import java.util.Arrays;

public class LINTCODE302 {
    /*Description
    * 给出一个数组
    * nums，将数组中的数两两配对。令数组 sums 为配对后每组数字的和，要求
    * sums 的极差最小。请计算并返回可能的最小的sums 的极差。极差就是数组中最大最小值的差值。
    * */

    public int digitalPairing(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int l=0,r=nums.length-1;
        while(l<r){
            int cur=nums[l++]+nums[r--];
            max=Math.max(cur,max);
            min=Math.min(cur,min);
        }
        return max-min;
        // write your code here.
    }
}

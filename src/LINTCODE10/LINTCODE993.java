package LINTCODE10;

import java.util.Arrays;

public class LINTCODE993 {
    /*Description
    * 给一个有 2n 个整数的数组，你的任务是把这些整数分成 n 组，如(a1, b1)，(a2, b2)，...，(an, bn)。
    * 并且使得 i 从 1 到 n 的 min(ai, bi)之和尽可能的大。
    * */

    /*Solution
    * 排序，然后取奇数位的和
    * */

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<nums.length;i+=2){
            result+=nums[i];
        }
        return result;
        // Write your code here
    }
}

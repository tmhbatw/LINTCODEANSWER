package LINTCODE3;

import java.util.List;

public class LINTCODE297 {
    /*Description
    * 寻找 n 个数中的最大值。
    * */

    public int maxNum(List<Integer> nums) {
        int max=Integer.MIN_VALUE;
        for(int cur:nums)
            max=Math.max(cur,max);
        return max;
        // write your code here
    }
}

package LINTCODE10;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE911 {
    /*Description
    *给一个数组nums和目标值k，找到数组中最长的子数组，使其中的元素和为k。如果没有，则返回0。
    * */

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=0;
        map.put(0,-1);
        int preSum=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            result=Math.max(result,i-map.getOrDefault(preSum-k,i));
            if(!map.containsKey(preSum))
                map.put(preSum,i);
        }
        return result;
        // Write your code here
    }
}

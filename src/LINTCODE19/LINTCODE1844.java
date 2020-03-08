package LINTCODE19;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1844 {
    /*Description
    * 给定一个整数数组和一个整数k，你需要找到和为k的最短子数组，并返回它的长度。
    * 如果没有这样的子数组，返回-1.
    * */

    public int subarraySumEqualsKII(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int curSum=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            int pre=curSum-k;
            if(map.containsKey(pre)){
                result=Math.min(result,i-map.get(pre));
            }
            map.put(curSum,i);
        }
        return result==Integer.MAX_VALUE?-1:result;
        // write your code here
    }
}

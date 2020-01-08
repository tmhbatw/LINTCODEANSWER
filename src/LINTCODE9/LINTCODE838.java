package LINTCODE9;

import java.util.HashMap;

public class LINTCODE838 {
    /*Description
    * 给定一个整数数组和一个整数k，你需要找到连续子数列的和为k的总个数。
    * */

    /*Solution
    *将前缀数组的和保存在一个哈希表中
    *  */
    public int subarraySumEqualsK(int[] nums, int k) {
        int res=0;
        int curSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            if(map.containsKey(curSum-k))
                res+=map.get(curSum-k);
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        return res;
        // write your code here
    }



    //暴力遍历方法，暴力拆解法时间复杂度O(n方)
/*    public int subarraySumEqualsK(int[] nums, int k) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int curSum=0;
            for(int j=i;j<nums.length;j++){
                curSum+=nums[i];
                if(curSum==k)
                    res++;
            }
        }
        return res;
        // write your code here
    }*/
}

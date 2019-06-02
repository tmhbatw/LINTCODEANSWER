package LINTCODE2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LINTCODE139 {

    /*Description
    *Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
    * */

    /*Solution
    * 连续数组之和可以创建一个数组，其中数组[i]的值为原数组从0到i的和
    * 那么原数组中所有的连续数组之和可以由新数组中两个数之差表示
    *新数组排序，比较相邻数之间最小值即为结果
    * 需要注意的是可以用map存储值与i的关系
    * 测试用例中有一个和为0的测试用例，略坑
    * */

    public int[] subarraySumClosest(int[] nums) {
        if(nums.length==1)
            return new int[]{0,0};
        int[] dp=new int[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for(int i=1;i<dp.length;i++){
            dp[i]=dp[i-1]+nums[i-1];
            if (map.containsKey(dp[i])) {
                return new int[]{map.get(dp[i]), i - 1};
            }
            map.put(dp[i],i);
        }
        Arrays.sort(dp);
        int index=0;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<dp.length;i++){
            if(Math.abs(dp[i]-dp[i-1])<min){
                index=i;
            }
            min=Math.min(Math.abs(dp[i]-dp[i-1]),min);
        }
        int start=map.get(dp[index]);
        int end=map.get(dp[index-1]);
        return new int[]{Math.min(start,end),Math.max(start,end)-1};
        // write your code here
    }
}

package LINTCODE10;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE994 {
    /*Description
    * 给一个二进制数组，找到 0 和 1 数量相等的子数组的最大长度
    * */

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int count=0;
        int length=nums.length;
        int result=0;
        for(int i=0;i< length;i++){
            if(nums[i]==0)
                count++;
            else
                count--;
            if(map.containsKey(count)){
                result=Math.max(result,i-map.get(count));
            }else
                map.put(count,i);
        }
        return result;
        // Write your code here
    }
}

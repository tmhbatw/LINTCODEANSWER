package LINTCODE7;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE610 {
    /*Description
    *给定一个整数数组，找到两个数的 差 等于目标值。index1必须小于index2。注意返回的index1和index2不是 0-based。
    * */

    public int[] twoSum7(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(nums[0],1);
        int[] result=new int[2];
        for(int i=1;i<nums.length;i++){
            result[1]=i+1;
            if(map.containsKey(nums[i]-target)){
                result[0]=map.get(nums[i]-target);
                return result;
            }
            if(map.containsKey(nums[i]+target)){
                result[0]=map.get(nums[i]+target);
                return result;
            }
            map.put(nums[i],i+1);
        }
        return result;
        // write your code here
    }
}

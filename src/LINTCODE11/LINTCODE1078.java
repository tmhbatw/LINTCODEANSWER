package LINTCODE11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1078 {
    /*Description
    * 给定由非负整数组成的非空数组，数组的度定义为出现频率最高的元素。
    * 找出最短的连续子数组，并使得它和原数组有相同的度。返回该连续子数组的长度。
    * */

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        HashMap<Integer,Integer> map3=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
            if (!map2.containsKey(nums[i])) {
                map2.put(nums[i], i);
            }
            map3.put(nums[i],i);
        }
        int max=Integer.MIN_VALUE;
        List<Integer> list=new ArrayList<>();
        for(Map.Entry entry:map1.entrySet()){
            int time= (int) entry.getValue();
            if(max<time){
                list=new ArrayList<>();
                list.add((Integer) entry.getKey());
                max=time;
            }
            if(max==time)
                list.add((Integer) entry.getKey());
        }
        int result=Integer.MAX_VALUE;
        for(int cur:list)
            result=Math.min(result,map3.get(cur)-map2.get(cur));
        return result+1;
        // write your code here
    }

}

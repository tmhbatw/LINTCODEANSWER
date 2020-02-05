package LINTCODE12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LINTCODE1187 {
    /*Description
    * 给定一个整数数组和一个整数k，您需要找到数组中唯一k-diff对的数量。
    * 这里k-diff对被定义为整数对(i, j)，其中i和j都是数组中的数字，它们的绝对差是k。
    * */

    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        if(k==0){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int cur:nums)
                map.put(cur,map.getOrDefault(cur,0)+1);
            int result=0;
            for(Map.Entry entry: map.entrySet())
                if((int)entry.getValue()>1)
                    result++;
                return result;
        }
        for(int cur:nums)
            set.add(cur);
        int result=0;
        for(int cur:set){
            if(set.contains(cur+k))
                result++;
        }
        return result;
        // Write your code here
    }
}

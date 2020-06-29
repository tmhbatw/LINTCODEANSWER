package LINTCODE19;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1880 {
    /*Description
    * 给定一个由N个整数组成的序列A，请你输出最大的值X，它恰好在A中出现X次。如果没有这样的值，你应该输出0。
    * */

    public int findX(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:arr)
            map.put(cur,map.getOrDefault(cur,0)+1);
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            if(((int)entry.getValue())==((int)entry.getKey()))
                result=Math.max((int)entry.getValue(),result);
        }
        return result;
        // write your code here
    }
}

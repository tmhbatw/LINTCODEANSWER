package LINTCODE20;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1910 {
    /*Description
    * 在给定的数组中，找到出现次数最多的数字。
    * 出现次数相同时，字典序小的优先。
    * */

    public int findNumber(int[] array) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:array){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int result=-1;
        int time=0;
        for(Map.Entry entry:map.entrySet()){
            int curTime=(int)entry.getValue();
            int curVal=(int)entry.getKey();
            if(curTime>time||curTime==time&&curVal<result){
                result=curVal;
                time=curTime;
            }
        }
        return result;
        // Write your code here.
    }
}

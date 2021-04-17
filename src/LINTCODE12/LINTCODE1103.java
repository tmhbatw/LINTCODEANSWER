package LINTCODE12;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LINTCODE1103 {
    /*Description
    * 给定一个整数数组 nums. 现在需要将 nums 拆分成若干个 (至少1个) 子序列, 并且每个子序列至少包含 3 个连续的整数.
    * 返回是否能做到这样的拆分.
    * */

    public boolean isPossible(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int cur:nums){
            int time=map.getOrDefault(cur,0);
            map.put(cur,time+1);
        }
        Map<Integer,Integer> res=new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            int key=(int)entry.getKey();
            int val=(int)entry.getValue();
            int exist=res.getOrDefault(key,0);

            if(exist>=val){
                res.put(key+1,res.getOrDefault(key+1,0)+val);
            }else{
                res.put(key+1,res.getOrDefault(key+1,0)+exist);
                val-=exist;

                if(map.getOrDefault(key+1,0)<val||map.getOrDefault(key+2,0)<val)
                    return false;
                map.put(key+1,map.get(key+1)-val);
                map.put(key+2,map.get(key+2)-val);
                res.put(key+3,val);
            }
        }
        return true;
        // write your code here
    }
}

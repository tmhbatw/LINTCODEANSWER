package LINTCODE12;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1148 {
    /*Description
    * 我们将一个和谐数组定义为是其最大值和最小值之间的差值恰好为1的数组。
    * 现在，给定一个整数数组，您需要在其所有可能的子序列中找到其最长的和谐子序列的长度。
    * */

    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int cur:nums)
            map.put(cur,map.getOrDefault(cur,0)+1);
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            int cur= (int) entry.getKey();
            if(map.containsKey(cur+1)){
                int time= (int) entry.getValue()+map.get(cur+1);
                result=Math.max(time,result);
            }
        }
        return result;
        // write your code here
    }
}

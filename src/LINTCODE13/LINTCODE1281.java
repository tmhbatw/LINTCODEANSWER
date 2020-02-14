package LINTCODE13;

import java.util.*;

public class LINTCODE1281 {
    /*Description
    *给定一个非空的整数数组，返回其中出现频率前k 高的元素。
    * */

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums)
            map.put(cur,map.getOrDefault(cur,0)+1);
        PriorityQueue<Map.Entry> queue=new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o2.getValue ()-(int) o1.getValue();
            }
        });
        for(Map.Entry entry:map.entrySet())
            queue.add(entry);
        List<Integer> result=new ArrayList<>();
        while(k-->0)
            result.add((int)queue.poll().getKey());
        return result;
        // Write your code here
    }
}

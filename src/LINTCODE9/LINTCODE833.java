package LINTCODE9;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LINTCODE833 {
    /*Description
    * 有一个进程序列，包含每一个进程的开始点和结束点。
    * 有一个询问序列，询问某个时间点有多少个进程在跑。
    * 请你返回询问序列的查询结果。
    * */

    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        TreeMap<Long,Integer> map=new TreeMap<>();
        for(Interval cur:logs){
            long start=cur.start;
            long end=cur.end+1L;
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
        }
        for(Map.Entry entry : map.entrySet()){
            long key= (long) entry.getKey();
            int pre = map.floorKey(key-1)==null?0:map.get(map.floorKey(key-1));
            map.put(key,(int)entry.getValue()+pre);
        }
        List<Integer> result=new ArrayList<>();
        for(int cur:queries){
            result.add(map.floorKey((long) cur)==null?0:map.get(map.floorKey((long) cur)));
        }
        return result;
        // Write your code here
    }
}

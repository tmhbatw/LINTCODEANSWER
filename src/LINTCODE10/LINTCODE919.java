package LINTCODE10;

import datastructure.Interval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LINTCODE919 {
    /*Description
    * 给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...]
    * (si < ei)，找到所需的最小的会议室数量。
    * */

        public int minMeetingRooms(List<Interval> intervals) {
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(Interval cur:intervals){
                int start=cur.start;
                map.put(start,map.getOrDefault(start,0)+1);
                int end=cur.end;
                map.put(end,map.getOrDefault(end,0)-1);
            }
            int count=0;
            int result=0;
            for(Map.Entry entry:map.entrySet()){
                count+=(int)entry.getValue();
                result=Math.max(result,count);
            }
            return result;
            // Write your code here
        }
}

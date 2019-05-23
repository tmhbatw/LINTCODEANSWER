package LINTCODE;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE30 {

    /*Description
    * Given a non-overlapping interval list which is sorted by start point.
    * Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).
    * */

    /*Solution
    * 根据区间列表中区间大小不同进行不同的出路
    * */

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<>();
        int temp=0;
        //将新区间左边的区间输出
        for(;temp<intervals.size();temp++){
            Interval curr=intervals.get(temp);
            if(curr.end>=newInterval.start)
                break;
            result.add(curr);
        }
        //将与新区间交互的区间结合成新区间

        for(;temp<intervals.size();temp++){
            Interval curr=intervals.get(temp);
            if(newInterval.end<curr.start)
                break;

            newInterval=new Interval(Math.min(curr.start,newInterval.start),Math.max(curr.end,newInterval.end));

        }
        result.add(newInterval);
        //将新区间右边的区间输出
        for(;temp<intervals.size();temp++){
            Interval curr=intervals.get(temp);
            result.add(curr);
        }

        return result;

    }
}

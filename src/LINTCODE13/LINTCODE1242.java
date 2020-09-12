package LINTCODE13;

import datastructure.Interval;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1242 {
    /*Description
    * 给定一些区间，找到需要移除的最小区间数，以使其余的区间不重叠。
    * */

    public int eraseOverlapIntervals(List<Interval> intervals) {
        if(intervals.size()==0)
            return 0;
        PriorityQueue<Interval> p=new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start)
                    return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });
        p.addAll(intervals);
        int result=0;
        int pre=p.poll().end;
        while(!p.isEmpty()){
            Interval cur=p.poll();
            if(cur.start<pre){
                result++;
                pre=Math.min(cur.end,pre);
            }else
                pre=cur.end;
        }
        return result;
        // write your code here
    }
}

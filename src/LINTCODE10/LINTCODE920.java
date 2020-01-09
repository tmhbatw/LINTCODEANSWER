package LINTCODE10;

import datastructure.Interval;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE920 {
    /*Description
    * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
    * */

    /*Solution
    *排序，比较是否有重合即可
    * */

    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> queue=new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        for(Interval cur:intervals)
            queue.add(cur);
        int last=0;
        while(!queue.isEmpty()){
            Interval cur=queue.poll();
            if(cur.start<last)
                return false;
            last=Math.max(last,cur.end);
        }
        return true;
        // Write your code here
    }
}

package LINTCODE9;

import datastructure.Interval;

import java.util.*;

public class LINTCODE850 {
    /*Description
    * 我们得到一个员工的schedule列表,代表每个员工工作时间。
    * 每个员工有一个不重合时段的列表 Intervals,这些时段按序排列。
    * 返回一个所有员工共有的空闲时段的列表，并按序排列。
    * 我们的Intervals是一个一维数组，其中每两个数表示一个区间，即[1,2,8,10]表示这个员工的工作时间是[1,2]和[8,10]。
    * 并且,我们的答案不会包括像[5,5]这样的,因为它们的长度是0。
    * */

    public List<Interval> employeeFreeTime(int[][] schedule) {
        List<Interval> list=new ArrayList<>();
        for(int[] cur:schedule){
            for(int i=0;i<cur.length;i+=2){
                list.add(new Interval(cur[i],cur[i+1]));
            }
        }
        Collections.sort(list,(o1, o2)->{
            return o1.start-o2.start;
        });
        int start=list.get(0).start;
        List<Interval> result=new ArrayList<>();
        for(Interval cur:list){
            if(start<cur.start)
                result.add(new Interval(start,cur.start));
            start=Integer.max(start,cur.end);
        }
        return result;
        // Write your code here
    }
}

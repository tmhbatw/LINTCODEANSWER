package LINTCODE6;

import datastructure.Interval;

import java.util.*;

public class LINTCODE577 {

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        if(intervals.size()==0)
            return Collections.emptyList();
        List<Interval> result=new ArrayList<>();
        for(List<Interval> list:intervals){
            result.addAll(list);
        }
        Collections.sort(result, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        for(Interval curr:result){
            System.out.println(curr.start+"  "+curr.end);
        }
        List<Interval> res=new ArrayList<>();
        Interval curr=result.get(0);
        for(int i=1;i<result.size();i++){
            if(curr.end<=result.get(i).start){
                curr.end=Math.max(curr.end,result.get(i).end);
            }else{
                res.add(curr);
                curr=result.get(i);
            }
        }
        res.add(curr);
        return res;
        // write your code here
    }
}

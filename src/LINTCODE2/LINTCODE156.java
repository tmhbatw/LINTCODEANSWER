package LINTCODE2;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE156 {
    /*Description
    *给出若干闭合区间，合并所有重叠的部分。
    * */

    /*Solution
    * 因为区间之间是无序的，因此需要建立一个小根堆保存所有的区间
    * 逐一合并进行输出即可
    * */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0)
            return Collections.emptyList();
        List<Interval> result=new ArrayList<>();

        PriorityQueue<Interval> queue=new PriorityQueue<>((o1, o2) -> {
            return o1.start-o2.start;
        });

        for(int i=0;i<intervals.size();i++){
            queue.add(intervals.get(i));
        }
        Interval node=null;
        while(!queue.isEmpty()){
            Interval curr=queue.poll();
            if(node==null){
                node=curr;
                continue;
            }else if(node.end>=curr.start){
                node.end=Math.max(node.end,curr.end);
                continue;
            }else{
                result.add(node);
                node=curr;
            }
        }
        result.add(node);
        return result;
        // write your code here
    }
}

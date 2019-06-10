package LINTCODE4;

import datastructure.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE391 {

    /*Description
    * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
    * */

    /*Solution
    * 创建一个小根堆来存储数据,使end时间较小的排在前面，给飞机列表排序，使出发时间较少的排在前面
    * 当有飞机起飞时，判断是否有飞机返航，并将飞机压入栈中，此时栈的大小就是同时在天空中飞机的最大数量
    * */

    public int countOfAirplanes(List<Interval> airplanes) {
        PriorityQueue<Interval> queue=new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        Collections.sort(airplanes, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int result=0;
        for(int i=0;i<airplanes.size();i++){
            Interval curr=airplanes.get(i);
            while(!queue.isEmpty()&&queue.peek().end<=curr.start){
                queue.poll();
            }
            queue.add(curr);
            result=Math.max(result,queue.size());
        }
        return result;
        // write your code here
    }
}

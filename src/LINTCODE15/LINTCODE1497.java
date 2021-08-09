package LINTCODE15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1497 {
    /*Description
    * 汽车从起始位置行驶到目的地，该目的地位于起始位置以东的目标英里处。
    * 一路上，有加油站。 每个station[i]代表一个加油站，它位于起始位置以东station[i] [0]英里处，并且有station[i] [1]升汽油。
    * 汽车开始时有一个无限的汽油罐，最初燃料中含有燃料。 它每1英里就会使用1升汽油。
    * 当汽车到达加油站时，它可能停下来并加油，将所有汽油从车站转移到汽车中。
    * 为了到达目的地，汽车必须加油的最少次数是多少？ 如果无法到达目的地，则返回-1。
    * 请注意，如果汽车到达加油站时燃料正好为0，汽车仍然可以在那里加油。 如果汽车在剩余0燃料的情况下到达目的地，仍然认为已经到达。
    * 1 <= target, startFuel, stations[i][1] <= 10^9
    * 0 <= stations.length <= 500
    * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
    * */

    public int minimumNumberofRefuelingStops(int target, int startFuel, List<List<Integer>> stations) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int curPos=0;
        List<Integer> targetList=new ArrayList<>();
        targetList.add(target);
        targetList.add(0);
        stations.add(targetList);
        int result=0;
        for(List<Integer> list:stations){
            int consume=list.get(0)-curPos;
            while(consume>startFuel){
                if(q.isEmpty())
                    return -1;
                startFuel += q.poll();
                result++;
            }
            startFuel -= consume;
            curPos = list.get(0);
            q.add(list.get(1));
        }
        return result;
        // Write your code here.
    }
}

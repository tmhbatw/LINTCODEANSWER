package LINTCODE15;

import java.util.*;

public class LINTCODE1408 {
    /*Description
    * 一辆汽车在一条笔直的道路上行驶，一开始有original单位的汽油。
    * 这条笔直的道路上有n个加油站，第i个加油站距离汽车出发位置的距离为distance[i]单位距离，可以给汽车加apply[i]单位汽油。
    * 汽车每行驶1单位距离会消耗1单位的汽油，假设汽车的油箱可以装无限多的汽油。
    * 目的地距离汽车出发位置的距离为target，请问汽车能否到达目的地，如果可以返回最少的加油次数，否则返回-1。
    * 所有的加油站都在汽车行驶的方向上。
    * */

    class GasStation{
        int distance;
        int apply;
        public GasStation(int distance, int apply){
            this.distance = distance;
            this.apply = apply;
        }
    }

    public int getTimes(int target, int original, int[] distance, int[] apply) {
        List<GasStation> list=new ArrayList<>();
        for(int i =0;i<distance.length;i++){
            if(distance[i]<target){
                list.add(new GasStation(distance[i],apply[i]));
            }
        }
        Collections.sort(list,((o1, o2) -> o1.distance-o2.distance));
        list.add(new GasStation(target,0));
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int count =0;
        for(GasStation cur:list){
            while(cur.distance>original){
                if(q.isEmpty())
                    return -1;
                original += q.poll();
                count++;
            }
            q.add(cur.apply);
        }
        return count;
        // Write your code here
    }
}

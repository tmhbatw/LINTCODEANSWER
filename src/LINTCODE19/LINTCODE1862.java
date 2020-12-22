package LINTCODE19;

import java.util.*;

public class LINTCODE1862 {
    /*Descripiton
    * 有一棵n个节点的树，节点编号是0至n−1,其中0号节点是根节点，i号节点的父亲节点是father[i]。
    * 现在要对树浇水，把水撒到根节点上，水会顺着每一条边流下去，从i号节点的父亲流到i号节点需要time[i]的时间，
    * 请问需要多久水才能流到所有节点上。
    * */

    public int timeToFlowerTree(int[] father, int[] time) {
        if(father.length<=1)
            return 0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<father.length;i++){
            List<Integer> cur=map.getOrDefault(father[i],new ArrayList<>());
            cur.add(i);
            map.put(father[i],cur);
        }
        Queue<Integer> id=new LinkedList<>();
        Queue<Integer> cost=new LinkedList<>();
        id.add(0);
        cost.add(0);
        int result=0;
        while(!id.isEmpty()){
            int cur=id.poll();
            int curCost=cost.poll();
            result=Math.max(result,curCost);
            List<Integer> list=map.getOrDefault(cur,new ArrayList<>());
            for(int curr:list){
                id.add(curr);
                cost.add(curCost+time[curr]);
            }
        }
        return result;
        // write your code here
    }


}

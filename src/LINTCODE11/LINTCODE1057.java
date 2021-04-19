package LINTCODE11;

import java.util.*;

public class LINTCODE1057 {
    /*Description
    * 有 N个网络节点，从 1 到 N标记.
    * 给定 times，一个旅行时间和有向边列表 times[i] = (u, v, w)，其中u 是起始点， v是目标点， w是一个信号从起始到目标点花费的时间。
    * 现在，我们从一个特定节点 K发出信号，所有节点收到信号需要花费多长时间? 如果不可能，返回-1。
    * */

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int[] cur:times){
            int u=cur[0];
            if(!map.containsKey(u))
                map.put(u,new ArrayList<>());
            List<int[]> list=map.get(u);
            list.add(new int[]{cur[1],cur[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] reached=new boolean[N+1];
        int count=N;
        q.add(new int[]{K,0});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int u=cur[0];
            if(reached[u])
                continue;
            reached[u]=true;
            count--;
            if(count==0)
                return cur[1];
            List<int[]> list=map.getOrDefault(u,new ArrayList<>());
            for(int[] curr:list){
                if(reached[curr[0]])
                    continue;
                q.add(new int[]{curr[0],curr[1]+cur[1]});
            }
        }
        return -1;
        // Write your code here
    }
}

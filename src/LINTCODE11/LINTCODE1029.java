package LINTCODE11;

import java.util.*;

public class LINTCODE1029 {
    /*Description
    * 有n个城市被一些航班所连接。每个航班 (u,v,w) 从城市u出发，到达城市v，价格为w。
    * 给定城市数目 n，所有的航班flights。你的任务是找到从起点src到终点站dst的最便宜线路的价格，而旅途中最多只能中转K次。
    * 如果没有找到合适的线路，返回 -1。
    * */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] num=new int[n];
        Arrays.fill(num,Integer.MAX_VALUE);
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] cur:flights){
            map.putIfAbsent(cur[0],new ArrayList<>());
            List<Integer> list=map.get(cur[0]);
            list.add(cur[1]);
            list.add(cur[2]);
        }
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});
        num[src]=0;
        for(int i=0;i<=K;i++){
            int size=q.size();
            for(int j=0;j<size;j++){
                int[] cur=q.poll();
                List<Integer> list=map.getOrDefault(cur[0],new ArrayList<>());
                for(int k=0;k<list.size();k+=2){
                    int nextVal=list.get(k+1)+cur[1];
                    if(nextVal<num[list.get(k)]){
                        num[list.get(k)]=nextVal;
                        q.add(new int[]{list.get(k),nextVal});
                    }
                }
            }
        }
        return num[dst]==Integer.MAX_VALUE?-1:num[dst];
        // write your code here
    }
}

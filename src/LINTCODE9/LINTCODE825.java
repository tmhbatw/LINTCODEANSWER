package LINTCODE9;

import java.util.*;

public class LINTCODE825 {
    /*Description
    * 现在有一个城市的 N 个公车信息，route[i] 储存着第 i 辆公交车经过的公交车站，
    * 请你求车站 A 到车站 B 的最少换乘，如果无法从车站 A 到达车站 B 返回 -1。
    * */

    public int getMinTransferNumber(int N, int[][] route, int A, int B) {
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        int busStation=0;
        for(int i=0;i<route.length;i++){
            for(int j=0;j<route[i].length;j++) {
                HashSet<Integer> cur=map.getOrDefault(route[i][j],new HashSet<>());
                cur.add(i);
                map.put(route[i][j],cur);
                busStation=Math.max(busStation,route[i][j]);
            }
        }
        int[] dp=new int[busStation+1];
        dp[A]=1;
        Set<Integer> bus=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curBusStation=queue.poll();
                Set<Integer> curBusNumber=map.get(curBusStation);
                Iterator it=curBusNumber.iterator();
                while(it.hasNext()){
                    int curBus= (int) it.next();
                    if(bus.contains(curBus))
                        continue;
                    for(int j=0;j<route[curBus].length;j++){
                        if(dp[route[curBus][j]]!=0){
                            continue;
                        }
                        dp[route[curBus][j]]=dp[curBusStation]+1;
                        queue.add(route[curBus][j]);
                    }
                    bus.add(curBus);
                }
            }
        }
        return dp[B]-1;
        // Write your code here
    }

}

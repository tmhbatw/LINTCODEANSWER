package LINTCODE11;

import java.util.*;

public class LINTCODE1002 {
    /*Description
    * 给定一个巴士路线列表 routes. routes[i] 是第 i 辆巴士的循环路线. 例如, 如果 routes[0] = [1, 5, 7],
    * 那么第一辆巴士按照 1 -> 5 -> 7 -> 1 -> 5 -> 7 ... 的路径不停歇地行进.
    * 给定 S 和 T, 问在仅仅乘巴士的情况下, 从 S 赶到 T 最少乘多少辆不同的巴士? 如果无法赶到, 返回 -1.
    * */

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T)
            return 0;

        Map<Integer,Boolean> reached=new HashMap<>();
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int cur:routes[i]){
                if(!map.containsKey(cur)) {
                    map.put(cur, new ArrayList<>());
                    reached.put(cur,false);
                }
                List<Integer> list=map.get(cur);
                list.add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(S);
        reached.put(S,true);
        if(!map.containsKey(T))
            return -1;
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            distance++;
            for(int i=0;i<size;i++){
                int cur=q.poll();
                List<Integer> routeList=map.get(cur);
                for(int pos:routeList) {

                    for (int nextPos : routes[pos]) {
                        if (nextPos == T)
                            return distance;

                        if (reached.get(nextPos))
                            continue;
                        reached.put(nextPos, true);
                        q.add(nextPos);
                    }
                }
            }
        }
        return -1;
        // Write your code here
    }
}

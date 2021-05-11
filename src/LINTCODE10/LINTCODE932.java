package LINTCODE10;

import java.util.*;

public class LINTCODE932 {
    /*Description
    * 给两个数组a,b,代表a[i]与b[i]是朋友，再给出两个数组c,d，表示询问c[i]和d[i]是否为三跳之内的朋友。
    * （比如A与B是朋友，B与C是朋友，那么B算A的一跳朋友，C算A的二跳朋友）。
    * */


    public int[] withinThreeJumps(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.putIfAbsent(a[i],new HashSet<>());
            map.putIfAbsent(b[i],new HashSet<>());
            map.get(a[i]).add(b[i]);
            map.get(b[i]).add(a[i]);
        }
        int[] result=new int[c.length];
        for(int i=0;i<c.length;i++){
            result[i]=getVal(c[i],d[i],map);
        }
        return result;
        // Write your code here
    }

    private int getVal(int c,int d,Map<Integer,Set<Integer>> map){
        if(!map.containsKey(c)||!map.containsKey(d))
            return 0;
        Set<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(c);
        set.add(c);
        int jump=1;
        while(jump<=3&&!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++) {
                Set<Integer> curSet=map.get(q.poll());
                for (int cur : curSet) {
                    if (cur == d)
                        return 1;
                    if (set.contains(cur))
                        continue;
                    set.add(cur);
                    q.add(cur);
                }
            }
            jump++;
        }
        return 0;
    }
}

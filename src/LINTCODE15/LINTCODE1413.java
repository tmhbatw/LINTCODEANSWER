package LINTCODE15;

import java.util.*;

public class LINTCODE1413 {
    /*Description
    * 给出两个list x，y，代表x[i]与y[i]之间有一条边，整个边集构成一棵树，1为根，
    * 现在有个list a,b，表示询问节点a[i]与b[i]是什么关系，如果a[i]与b[i]是兄弟，
    * 即有同一个父节点，输出1，如果a[i]与b[i]是父子关系，输出2，否则输出0。
    * */

    public int[] tree(int[] x, int[] y, int[] a, int[] b) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0;i<x.length;i++){
            if(!map.containsKey(x[i]))
                map.put(x[i],new HashSet<>());
            if(!map.containsKey(y[i]))
                map.put(y[i],new HashSet<>());
            map.get(x[i]).add(y[i]);
            map.get(y[i]).add(x[i]);
        }
        boolean[] reached=new boolean[100001];
        Map<Integer,Integer> fatherMap=new HashMap<>();
        fatherMap.put(1,1);
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        reached[1]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            Set<Integer> set=map.get(cur);
            for(int curr:set){
                if(reached[curr])
                    continue;
                reached[curr]=true;
                fatherMap.put(curr,cur);
                q.add(curr);
            }
        }
        int[] result=new int[a.length];
        for(int i=0;i<result.length;i++){
            if(fatherMap.get(a[i])==b[i]||fatherMap.get(b[i])==a[i])
                result[i]=2;
            else if(fatherMap.get(a[i]).equals(fatherMap.get(b[i])))
                result[i]=1;
        }
        return result;
        // Write your code here
    }
}

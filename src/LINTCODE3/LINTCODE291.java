package LINTCODE3;

import java.util.*;

public class LINTCODE291 {
    /*Description
    * 给出由n个结点，n−1条边组成的一棵树。求这棵树的第二直径，也就是两两点对之间距离的次大值。
    * 给出大小为(n−1)×3的数组edge,edge[i][0],edge[i][1],edge[i][2],
    * 表示第i条边是从edge[i][0]连向edge[i][1]，长度为edge[i][2]的无向边。
    * */

    long max=0;
    long second=0;
    int length=0;

    public long getSecondDiameter(int[][] edge) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,List<int[]>> relationship=new HashMap<>();
        for(int[] cur:edge){
            cur[0]=getVal(cur[0],map);
            cur[1]=getVal(cur[1],map);
            relationship.putIfAbsent(cur[0],new ArrayList<>());
            relationship.putIfAbsent(cur[1],new ArrayList<>());
            relationship.get(cur[0]).add(new int[]{cur[1],cur[2]});
            relationship.get(cur[1]).add(new int[]{cur[0],cur[2]});
        }


        Queue<Integer> q=new LinkedList<>();

        int root=0;
        Map<Integer,List<int[]>> mapChildren=new HashMap<>();
        Map<Integer,Integer> mapFather=new HashMap<>();
        mapFather.put(0,0);
        q.add(root);
        while(!q.isEmpty()){
            int cur=q.poll();
            List<int[]> children=new ArrayList<>();

            int father=mapFather.get(cur);
            for(int[] c:relationship.get(cur)){
                if(c[0]==father)
                    continue;
                children.add(c);
                mapFather.put(c[0],cur);
                q.add(c[0]);
            }
            mapChildren.put(cur,children);
        }

        int[] degree=new int[length];
        for(Map.Entry<Integer,List<int[]>> entry:mapChildren.entrySet()){
            degree[entry.getKey()]=entry.getValue().size();
        }
        for(int i=0;i<length;i++)
            if(degree[i]==0)
                q.add(i);
        long[][] res=new long[length][2];
        while(!q.isEmpty()){
            int cur=q.poll();
            degree[mapFather.get(cur)]--;
            if(degree[mapFather.get(cur)]==0)
                q.add(mapFather.get(cur));

            if(!mapChildren.containsKey(cur)||mapChildren.get(cur).size()==0)
                continue;

            List<int[]> child=mapChildren.get(cur);
            List<Long> edges=new ArrayList<>();
            for(int[] next:child){
                getMax(edges, next[1]);
                for(int j=0;j<2;j++){
                    if(res[next[0]][j]==0)
                        continue;
                    long curEdge=res[next[0]][j]+next[1];
                    getMax(edges,curEdge);
                }
                for(int j=0;j<2;j++){
                    if(res[next[0]][j]!=0)
                        edges.add(res[next[0]][j]+next[1]);
                }
                edges.add((long) next[1]);

            }
            Collections.sort(edges);
            res[cur][0]=edges.get(edges.size()-1);
            res[cur][1]=edges.size()>=2?edges.get(edges.size()-2):0;
        }
        return second;
        // write your code here
    }

    private void getMax(List<Long> edges, long edge){
        getVal(edge);
        for(long cur:edges){
            getVal(edge+cur);
        }
    }

    private void getVal(long cur){
        if(cur>=max){
            second=max;
            max=cur;
        }else if(cur>second)
            second=cur;
    }

    private int getVal(int cur, Map<Integer,Integer> map){
        if(!map.containsKey(cur))
            map.put(cur,length++);
        return map.get(cur);
    }
}

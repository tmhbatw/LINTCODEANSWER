package LINTCODE17;

import java.util.*;

public class LINTCODE1600 {
    /*Description
    * 从具有从0到N-1的节点的无向图（“原始图”）开始，对一些边进行细分。
    * 该图给出如下：edges [k]是整数对（i，j，n）的列表，使得（i，j）是原始图的边，
    * n是该边缘上新节点的总数。
    *
    * 然后，从原始图中删除边（i，j），将新节点（x_1，x_2，...，x_n）添加到原始图中，
    * 和n + 1个新边（i，x_1），（x_1，x_2），（x_2，x_3），...，（x_ {n-1}，x_n），（x_n，j）被添加到原始图。
    * 现在，您从原始图形开始于节点0，并且在每次移动中，您沿着一条边移动。
    * 返回最多M次移动可以达到的节点数。
    * */

    public int reachableNodesInSubdividedGraph(int[][] edges, int M, int n) {
        Map<Integer, Map<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,new HashMap<>());

        for(int[] edge:edges){
            map.get(edge[0]).put(edge[1],edge[2]);
            map.get(edge[1]).put(edge[0],edge[2]);
        }

        int res=0;
        boolean[] reached=new boolean[n];
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o2[1]-o1[1];
        });
        q.add(new int[]{0,M});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(reached[cur[0]])
                continue;

            res++;
            reached[cur[0]]=true;
            Map<Integer,Integer> list=map.get(cur[0]);

            int move=cur[1];
            for(int key:list.keySet()){

                int val=list.get(key);
                int add=move;
                if(move>=val+1){
                    add=val;
                    q.add(new int[]{key,move-val-1});
                }

                map.get(key).put(cur[0],val-add);
                res+=add;
            }
        }

        return res;
        // Write your code here.
    }
}

package LINTCODE11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE1031 {
    /*Description
    * 给定一个无向图 graph, 输出 true 当且仅当这个图是可以被二分的（也叫二部图）。
    * 如果一个图是二部图，则意味着我们可以将图里的点集分为两个独立的子集A和B，
    * 并且图中所有的边都是一个端点属于A，另一个端点属于B。
    * 关于图的表示：graph[i] 为一个列表，表示与节点i有边相连的节点。
    * 这个图中一共有 graph.length 个节点，为0到graph.length-1。
    * 图中没有自边或者重复的边存在，即: graph[i] 中不包含 i, 也不会包含某个点两次。
    * */

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        boolean[] reached=new boolean[n];
        for(int i=0;i<n;i++){
            if(reached[i])
                continue;
            Set<Integer>[] set=new Set[2];
            for(int j=0;j<2;j++)
                set[j]=new HashSet<>();
            int type=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            reached[i]=true;
            set[type].add(i);
            while(!q.isEmpty()){
                int nextType = 1^type;
                int size=q.size();
                while(size-->0){
                    int cur=q.poll();
                    int[] next=graph[cur];
                    for(int curr:next){
                        if(set[type].contains(curr))
                            return false;
                        if(reached[curr])
                            continue;
                        reached[curr]=true;
                        set[nextType].add(curr);
                        q.add(curr);
                    }
                }
                type=nextType;
            }
            System.out.println(set[0]);
            System.out.println(set[1]);
        }
        return true;
        // Write your code here
    }
}

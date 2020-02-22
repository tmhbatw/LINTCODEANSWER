package LINTCODE9;

import datastructure.UndirectedGraphNode;

import java.util.*;

public class LINTCODE814 {
    /*Description
    * 给定一个无向图, 图中所有边的长度为1, 再选定图中的两个节点, 返回这两个节点之间最短的路径的长度.
    * */

    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        Set<UndirectedGraphNode> set=new HashSet<>();
        int result=0;
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(A);
        set.add(A);
        while(!queue.isEmpty()){
            int size=queue.size();
            result++;
            for(int i=0;i<size;i++) {
                UndirectedGraphNode cur = queue.poll();
                List<UndirectedGraphNode> neighbor = cur.neighbors;
                for(UndirectedGraphNode node:neighbor){
                    if(node==B)
                        return result;
                    if(set.contains(node))
                        continue;
                    queue.add(node);
                    set.add(node);
                }
            }
        }
        return -1;
        // Write your code here
    }


}

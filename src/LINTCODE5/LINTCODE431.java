package LINTCODE5;

import datastructure.UndirectedGraphNode;

import java.util.*;

public class LINTCODE431 {
    /*Description
    *找出无向图中所有的连通块。
    * 图中的每个节点包含一个label属性和一个邻接点的列表。
    * （一个无向图的连通块是一个子图，其中任意两个顶点通过路径相连，且不与整个图中的其它顶点相连。）
    * 你需要返回 label 集合的列表.
    * */

    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> result=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(UndirectedGraphNode node:nodes){
            if(set.contains(node.label))
                continue;
            List<Integer> res=new ArrayList<>();
            set.add(node.label);
            Queue<UndirectedGraphNode> queue=new LinkedList<>();
            queue.add(node);
            res.add(node.label);
            while(!queue.isEmpty()){
                UndirectedGraphNode cur=queue.poll();
                List<UndirectedGraphNode> list=cur.neighbors;
                for(UndirectedGraphNode neighbor:list){
                    if(!set.contains(neighbor.label)){
                        set.add(neighbor.label);
                        queue.add(neighbor);
                        res.add(neighbor.label);
                    }
                }
            }
            Collections.sort(res);
            result.add(res);
        }
        return result;
        // write your code here
    }
}

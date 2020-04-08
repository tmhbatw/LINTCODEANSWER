package LINTCODE7;

import datastructure.UndirectedGraphNode;

import java.util.*;

public class LINTCODE618 {
    /*Description
    * 给定一张 无向图，一个 节点 以及一个 目标值，返回距离这个节点最近 且 值为目标值的节点，如果不能找到则返回 NULL。
    * 在给出的参数中, 我们用 map 来存节点的值
    * */

    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if(node==null)
            return null;
        if(values.get(node)==target)
            return node;
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        Set<UndirectedGraphNode> set=new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            List<UndirectedGraphNode> list=queue.poll().neighbors;
            for(UndirectedGraphNode cur:list){
                if(set.contains(cur))
                    continue;
                if(values.get(cur)==target)
                    return cur;
                set.add(cur);
                queue.add(cur);
            }
        }
        return null;
        // write your code here
    }
}

package LINTCODE2;

import datastructure.UndirectedGraphNode;

import java.util.*;

public class LINTCODE137 {
    /*Description
    * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. Nodes are labeled uniquely.
You need to return a deep copied graph, which has the same structure as the original graph, and any changes to the new graph will not have any effect on the original graph.
    * */

    /*Solution
    * 可以创建一个map用来保存当前节点是否备份过
    * 使用一个队列，为我们只进行过备份但是没有为邻居备份的节点构建邻居节点
    * 遍历结束即可备份完当前的图结构
    * */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;

        //用一个map储存新旧节点之间的关系，当map中有备份那么说明已经备份过了，若没有则需要进行备份
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        UndirectedGraphNode result=new UndirectedGraphNode(node.label);
        map.put(node,result);

        //创建一个队列，用来保存只是备份过map但是并没有复制邻居的节点
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(node);
        while(queue.isEmpty()){
            UndirectedGraphNode curr=queue.poll();
            ArrayList<UndirectedGraphNode> neigh=curr.neighbors;
            for(UndirectedGraphNode nod:neigh){

                //如果没有备份过那么要进行备份
                if(!map.containsKey(nod)){
                    map.put(nod,new UndirectedGraphNode(nod.label));
                    queue.add(nod);
                }

                //从map中读取出我们想要的节点加入新节点邻居节点中
                map.get(curr).neighbors.add(map.get(nod));
            }
        }
        return result;

        // write your code here
    }
}

package LINTCODE2;

import datastructure.DirectedGraphNode;

import java.text.DecimalFormat;
import java.util.*;

public class LINTCODE127 {
    /*Description
    *Given an directed graph, a topological order of the graph nodes is defined as follow:
    * For each directed edge A -> B in graph, A must before B in the order list.
    * The first node in the order can be any node in the graph with no nodes direct to it.
    * Find any topological order for the given graph.
    * */

    /*Solution
    * 使用一个哈希表存放一个点的入度（即几个节点能进入当前节点），入度为0的节点进入头节点
    * 当前节点中入度为1的节点作为下一节点，其他节点入度减1
    *
    * */

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode,Integer> degree=new HashMap<>();

        //计算入度
        for(DirectedGraphNode node:graph){
            for(DirectedGraphNode n:node.neighbors){
                if(!degree.containsKey(n))
                    degree.put(n,1);
                else{degree.put(n,degree.get(n)+1);}
            }
        }

        //找到没有入度的节点
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!degree.containsKey(node)) {
                q.add(node);
                result.add(node);
                break;
            }
        }
        //BFS遍历
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                degree.put(n, degree.get(n) - 1);
                if (degree.get(n) == 0) {
                    result.add(n);
                    q.add(n);
                }
            }
        }
        return result;
    }
}

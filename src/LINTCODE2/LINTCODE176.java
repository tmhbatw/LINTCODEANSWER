package LINTCODE2;

import datastructure.DirectedGraphNode;

import java.util.*;

public class LINTCODE176 {
    /*Description
    * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
    * */

    /*Solution
    * BFS算法
    * */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        Queue<DirectedGraphNode> queue=new LinkedList<>();
        queue.add(s);
        Set<DirectedGraphNode> set=new HashSet<>();
        set.add(s);
        while(!queue.isEmpty()){
            ArrayList<DirectedGraphNode> list=queue.poll().neighbors;
            for(int i=0;i<list.size();i++){
                if(list.get(i).label==t.label)
                    return true;
                if(!set.contains(list.get(i))){
                    set.add(list.get(i));
                    queue.add(list.get(i));
                }
            }
        }
        return false;
        // write your code here
    }
}

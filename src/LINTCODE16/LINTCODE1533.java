package LINTCODE16;

import datastructure.DirectedGraphNode;

import java.util.*;

public class LINTCODE1533 {
    /*Description
    *给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    * */

    public List<List<Integer>> levelOrder(ArrayList<DirectedGraphNode> nodes) {
        if(nodes==null||nodes.size()==0)
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        Queue<DirectedGraphNode> queue=new LinkedList<>();
        queue.add(nodes.get(0));
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<size;i++){
                DirectedGraphNode curr=queue.poll();
                res.add(curr.label);
                queue.addAll(curr.neighbors);
            }
            result.add(res);
        }
        return result;
    }
}

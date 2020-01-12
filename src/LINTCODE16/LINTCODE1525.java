package LINTCODE16;

import datastructure.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1525 {
    /*Description
    * 给定一个 N 叉树，返回其节点值的后序遍历。
    * */

    public List<Integer> postorder(UndirectedGraphNode root) {
        if(root==null)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        postOrder(root,result);
        return result;
        // write your code here
    }

    private void postOrder(UndirectedGraphNode root,List<Integer> result){
        ArrayList<UndirectedGraphNode> cur=root.neighbors;
        for(UndirectedGraphNode curr:cur)
            postOrder(curr,result);
        result.add(root.label);
    }
}

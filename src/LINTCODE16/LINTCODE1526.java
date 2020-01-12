package LINTCODE16;

import datastructure.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1526 {
    /*Description
    *给定一个 N 叉树，返回其节点值的前序遍历。
    * */

    public List<Integer> preorder(UndirectedGraphNode root) {
        if(root==null)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        preOrder(root,result);
        return result;
        // write your code here
    }

    private void preOrder(UndirectedGraphNode root,List<Integer> result){
        result.add(root.label);
        List<UndirectedGraphNode> list=root.neighbors;
        for(UndirectedGraphNode cur:list)
            preOrder(cur,result);
    }
}

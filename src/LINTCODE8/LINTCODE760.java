package LINTCODE8;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE760 {
    /*Description
    * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    * */

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
                if(i==size-1){
                    list.add(cur.val);
                }
            }
        }
        return list;
        // write your code here
    }
}

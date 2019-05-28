package LINTCODE;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE70 {
    /*Description
    * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    * */

    /*Solution
    * 与上一题基本相同，只是结果相反
    * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result=new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                list.add(curr.val);
            }
            result.add(0,list);
        }
        return result;}
}

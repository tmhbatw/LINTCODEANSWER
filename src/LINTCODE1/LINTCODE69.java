package LINTCODE1;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE69 {
    /*Description
    *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    * Challenge
    * Challenge 1: Using only 1 queue to implement it.
    * Challenge 2: Use BFS algorithm to do it.
    * */

    /*Solution
    *与66题基本一致，注意记录每一层有多少个节点即可
    *  */

    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(list);
        }
        return result;
        // write your code here
    }


}

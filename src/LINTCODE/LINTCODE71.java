package LINTCODE;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE71 {
    /*Description
    *Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    * */

    /*Solution
    * 与69题基本一致，创建一个temp值用来存储当前为正序或倒序即可
    * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        boolean temp=true;
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
                if(temp) {
                    list.add(0,curr.val);
                }else{
                    list.add(curr.val);
                }
            }
            result.add(list);
            temp=temp==true?false:true;
        }
        return result;
        // write your code here
    }
}

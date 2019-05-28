package LINTCODE;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE66 {
    /*Description
    * Given a binary tree, return the preorder traversal of its nodes' values.
    * Challenge
    * Can you do it without recursion?
    * */

    /*Solution
    * 创建一个双队列数据结构用来保存所有的树节点
    * 从开始读取树直到全部被读取
    * */

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.pollLast();
            list.add(curr.val);
            if(curr.right!=null)
                queue.addFirst(curr.right);
            if(curr.left!=null)
                queue.addFirst(curr.left);


        }
        return list;
        // write your code here
    }

}

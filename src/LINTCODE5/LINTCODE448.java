package LINTCODE5;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE448 {
    /*Description
    *给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有则返回null
    * */

    /*Solution
    * 找到这一节点后，如果它有右节点则返回右节点的最左左节点；
    * 没有的情况下， 如果它为一个左节点，则返回其父节点；
    * 如果它为一个右节点，则返回第一个左节点的父节点的值
    * */


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        Stack<TreeNode> stack=new Stack();
        TreeNode father=null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur.val==p.val){
                if(cur.right!=null){
                    TreeNode curr=cur.right;
                    while(curr.left!=null){
                        curr=curr.left;
                    }
                    return curr;
                }else{
                    return father;
                }
            }
            if(cur.val<p.val){
                stack.push(cur.right);
            }else{
                father=cur;
                stack.push(cur.left);
            }
        }
        return null;

        // write your code here
    }
}

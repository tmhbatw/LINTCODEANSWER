package LINTCODE1;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE93 {


    /*Description
    *给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
    * */

    /*Solution
    * 下给出了遍历每一个节点判断是否符合标准的方法
    * */

    public   boolean isBalanced(TreeNode root) {
       Stack<TreeNode> stack=new Stack<>();
       stack.push(root);
       while(!stack.empty()){
           TreeNode curr=stack.pop();
           if(!judge(curr)){
               return false;
           }
           if(curr.left!=null){
               stack.push(curr.left);
           }
           if(curr.right!=null)
               stack.push(curr.right);
       }
       return true;
        // write your code here
    }

    private boolean judge(TreeNode curr){
        TreeNode left=curr.left,right=curr.right;
        Deque<TreeNode> le=new ArrayDeque<>();
        Deque<TreeNode> ri=new ArrayDeque<>();
        if(left!=null)le.push(left);
        if(right!=null)ri.push(right);
        int i=left==null?0:getLength(le),j=right==null?0:getLength(ri);
        return Math.abs(i-j)<=1;
    }
    private int getLength(Deque<TreeNode> stack){
        int length=0;
        while(!stack.isEmpty()){
            int size=stack.size();
            length++;
            for(int i=0;i<size;i++){
                TreeNode curr=stack.pollLast();
                if(curr.left!=null)
                    stack.push(curr.left);
                if(curr.right!=null)
                    stack.push(curr.right);
            }
        }
        return length;
    }



}

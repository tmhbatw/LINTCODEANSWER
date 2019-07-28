package LINTCODE6;

import datastructure.TreeNode;

public class LINTCODE595 {
    /*Description
    * 给一棵二叉树，找到最长连续路径的长度。
    * 这条路径是指 任何的节点序列中的起始节点到树中的任一节点都必须遵循 父-子 联系。最长的连续路径必须是从父亲节点到孩子节点（不能逆序）。
    * */

    private int result=0;
    public int longestConsecutive(TreeNode root) {
        recursion(root,0,-1);
        return result;

        // write your code here
    }

    private void recursion(TreeNode curr,int num,int lastVal){
        if(curr==null){
            result=Math.max(result,num);
            return;
        }
        if(curr.val-lastVal==1){
            recursion(curr.left,num+1,curr.val);
            recursion(curr.right,num+1,curr.val);
        }else{
            result=Math.max(result,num);
            recursion(curr.left,1,curr.val);
            recursion(curr.right,1,curr.val);
        }
    }
}

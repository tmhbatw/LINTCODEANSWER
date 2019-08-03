package LINTCODE7;

import datastructure.TreeNode;

public class LINTCODE614 {
    /*Description
    *给定一棵二叉树，找到最长连续序列(单调且相邻节点值相差为1)路径的长度(节点数)。
    * 路径起点跟终点可以为二叉树的任意节点。
    * */

    public int longestConsecutive2(TreeNode root) {
        if(root==null)
            return 0;
        int val=getSequenceAdd(root)+getSequenceReduce(root)-1;
        return Math.max(val,Math.max(longestConsecutive2(root.left),longestConsecutive2(root.right)));

        // write your code here
    }

    private int getSequenceAdd(TreeNode root){
        if(root==null){
            return 0;
        }
        int val=root.val;
        int add=1;
        if(root.left!=null&&root.left.val==val+1){
            add=Math.max(getSequenceAdd(root.left)+1,add);
        }
        if(root.right!=null&&root.right.val==val+1){
            add=Math.max(getSequenceAdd((root.right))+1,add);
        }
        return add;
    }
    private int getSequenceReduce(TreeNode root){
        if(root==null)
            return 0;
        int val=root.val;
        int reduce=1;
        if(root.left!=null&&root.left.val==val-1)
            reduce=Math.max(reduce,getSequenceReduce(root.left)+1);
        if(root.right!=null&&root.right.val==val-1)
            reduce=Math.max(reduce,getSequenceReduce(root.right)+1);
        return reduce;
    }


}

package LINTCODE12;

import datastructure.TreeNode;

public class LINTCODE1181 {
    /*Description
    * 给定一颗二叉树，您需要计算树的直径长度。 二叉树的直径是树中
    * 任意两个节点之间最长路径的长度。 此路径不一定会通过树根。
    * */

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        return getHeight(root.left)+1+getHeight(root.right);
        // write your code here
    }

    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}

package LINTCODE7;

import datastructure.TreeNode;

public class LINTCODE628 {
    /*Description
    *给你一棵二叉树，找二叉树中的一棵子树，他的所有节点之和最大。
    * 返回这棵子树的根节点。
    * */

    int value=Integer.MIN_VALUE;
    TreeNode result;

    public TreeNode findSubtree(TreeNode root) {
        getValue(root);
        return result;
        // write your code here
    }

    private int getValue(TreeNode root){
        if(root==null)
            return 0;
        int cur=root.val;
        cur+=getValue(root.left);
        cur+=getValue(root.right);
        if(cur>value) {
            value=cur;
            result = root;
        }
        return cur;
    }
}

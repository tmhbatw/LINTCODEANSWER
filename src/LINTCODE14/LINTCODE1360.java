package LINTCODE14;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE1360 {
    /*Description
    * 给定二叉树，返回它是否是自身的镜像（即这棵二叉树是否对称）。
    * */

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSame(root.left,root.right);
        // Write your code here
    }

    private boolean isSame(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null||left.val!=right.val)
            return false;
        return isSame(left.left,right.right)&&isSame(left.right,right.left);
    }
}

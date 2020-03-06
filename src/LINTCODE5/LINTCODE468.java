package LINTCODE5;

import datastructure.TreeNode;

public class LINTCODE468 {
    /*Description
    * 给你一颗二叉树，判断是否是对称二叉树
    * */

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSame(root.left,root.right);
        // write your code here
    }

    private boolean isSame(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null)
            return true;
        if(node1==null||node2==null||node1.val!=node2.val)
            return false;
        return isSame(node1.left,node2.right)&&isSame(node1.right,node2.left);

    }


}

package LINTCODE12;

import datastructure.TreeNode;

public class LINTCODE1172 {
    /*Description
     * 给定一个二叉树，返回整棵树的倾斜程度。
     * 一个节点的倾斜程度定义：左子树的所有节点和，与右子树所有节点和的绝对值差。空节点的倾斜程度定义为0。
     * 整棵树的倾斜程度定义：所有节点的倾斜程度之和。
     * */


    private int result=0;

    public int findTilt(TreeNode root) {
        recursion(root);
        return result;
        // Write your code here
    }

    private int recursion(TreeNode root){
        if(root==null)
            return 0;
        int left=recursion(root.left);
        int right=recursion(root.right);
        result+=Math.abs(right-left);
        return left+right+root.val;
    }
}

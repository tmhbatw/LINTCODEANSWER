package LINTCODE2;

import datastructure.TreeNode;

public class LINTCODE175 {
    /*Description
    *   Invert a binary tree.Left and right subtrees exchange.
    * */

    /*Solution
    * 递归试一下
    * */

    public void invertBinaryTree(TreeNode root) {
        recursion(root);
        // write your code here
    }

    private TreeNode recursion(TreeNode root){
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=recursion(right);
        root.right=recursion(left);
        return root;
    }
}

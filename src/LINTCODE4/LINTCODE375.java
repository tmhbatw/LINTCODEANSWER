package LINTCODE4;

import datastructure.TreeNode;

public class LINTCODE375 {
    /*Description
    * For the given binary tree, return a deep copy of it.
    * */

    /*Solution
    * 递归遍历即可
    * */

    public TreeNode cloneTree(TreeNode root) {
        return recursion( root);
        // write your code here
    }

    private TreeNode recursion(TreeNode root){
        if(root==null)
            return null;
        TreeNode node=new TreeNode(root.val);
        node.left=recursion(root.left);
        node.right=recursion(root.right);
        return node;
    }
}

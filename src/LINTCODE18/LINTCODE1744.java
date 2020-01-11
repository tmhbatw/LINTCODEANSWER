package LINTCODE18;

import datastructure.TreeNode;

public class LINTCODE1744 {

    /*Description
    * 给定一个二叉排序树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
    * */

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result=new TreeNode(0);
        inOrder(root,result);
        return result.right;
        // Write your code here.
    }

    private void inOrder(TreeNode root,TreeNode result){
        if(root==null)
            return;
        inOrder(root.left,result);
        result.right=new TreeNode(root.val);
        result=result.right;
        inOrder(root.right,result);

    }
}

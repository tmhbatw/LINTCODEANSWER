package LINTCODE18;

import datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1744 {

    /*Description
    * 给定一个二叉排序树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
    * */

    /*Solution
    * 可以使用一个全局变量用来存储已经排列的节点
    * */
    TreeNode result=new TreeNode(0);
    TreeNode cur=result;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return result.right;
        // Write your code here.
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        cur.right=new TreeNode(root.val);
        cur=cur.right;
        inOrder(root.right);
    }
}

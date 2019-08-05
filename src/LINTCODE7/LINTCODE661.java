package LINTCODE7;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE661 {
    /*Description
    *给定二叉搜索树(BST)，将其转换为更大的树，使原始BST上每个节点的值都更改为在原始树中大于等于该节点值的节点值之和(包括该节点)。
    * */

    int curSum=0;

    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        add(root);

        return root;
        // write your code here
    }

    private  void add(TreeNode root){
        if(root.right!=null) {
            add( root.right);
        }
        curSum+=root.val;
        root.val=curSum;
        if(root.left!=null)
            add(root.left);
    }

}

package LINTCODE9;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE878 {
    /*Description *
    *给定一个二叉树，从根开始返回其逆时针方向的边界值。边界包括左边界、叶和右边界，没有重复的节点。
    * 左边界的定义为从根到最左边节点的路径。右边界的定义为从根到最右边的节点的路径。
    * 如果根没有左子树或右子树，那么根本身就是最左边或者最右边的节点。注意，这个定义只适用于二叉树的根节点，而不适用于任何子树。
    * 而当根有左子树时，最左边的节点是：你以有先访问左子节点的方式遍历二叉树时，第一个碰到的叶子节点。最右边的节点的定义类似，方向相反。
    *  */


    private List<Integer> list=new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null)
            return list;
        list.add(root.val);
        if(root.left==null||root.right==null)
            return list;
        treeLeft(root.left);
        tree(root);
        treeRight(root.right);
        return list;
        // write your code here
    }

    private void tree(TreeNode root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        tree(root.left);
        tree(root.right);
    }

    private void treeLeft(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))
            return;
        list.add(root.val);
        if(root.left!=null)
            treeLeft(root.left);
        else
            treeLeft(root.right);
    }

    private void treeRight(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))
            return;
        if(root.right!=null)
            treeRight(root.right);
        else
            treeRight(root.left);
        list.add(root.val);
    }
}

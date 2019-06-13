package LINTCODE5;

import datastructure.TreeNode;

public class LINTCODE453 {

    /*Description
    * 将一棵二叉树按照前序遍历拆解成为一个 假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
    * */

    /*Solution
    * 中序输出？
    * */

    public void flatten(TreeNode root) {
        TreeNode result=new TreeNode(0);
        recursion(result,root);
        // write your code here
    }

    private TreeNode recursion(TreeNode result,TreeNode root){
        if(root==null)
            return result;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=null;
        result.right=root;
        result=result.right;
        result=recursion(result,left);
        result=recursion(result,right);
        return result;
    }
}

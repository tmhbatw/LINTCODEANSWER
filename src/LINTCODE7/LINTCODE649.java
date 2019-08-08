package LINTCODE7;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE649 {
    /*Description
    * 给定一个二叉树，其中所有右节点要么是具有兄弟节点的叶节点(有一个共享相同父节点的左节点)或空白，
    * 将其倒置并将其转换为树，其中原来的右节点变为左叶子节点。返回新的根节点。
    * */

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null) {
            stack.add(root);
            root=root.left;
        }
        TreeNode roots=stack.pop();
        TreeNode res=roots;
        while(!stack.empty()){
            TreeNode cur=stack.pop();
            roots.left=cur.right;
            roots.right=cur;
            cur.left=null;
            cur.right=null;
            roots=cur;
        }
        return res;
        // write your code here
    }
}

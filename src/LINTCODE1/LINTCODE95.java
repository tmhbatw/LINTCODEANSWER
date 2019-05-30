package LINTCODE1;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE95 {
    /*Description
    * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
    * 一棵BST定义为：
    * 节点的左子树中的值要严格小于该节点的值。
    * 节点的右子树中的值要严格大于该节点的值。
    * 左右子树也必须是二叉查找树。
    * 一个节点的树也是二叉查找树。
    * */

    /*Solution
    * 遍历每一个节点判断即可
    * */



    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode curr=stack.pop();
            if(!judge(curr))
                return false;
            if(curr.left!=null){
                stack.push(curr.left);
            }
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        return true;
        // write your code here
    }

    //判断某一结点是否大于其所有左边的节点，是否小于其所有左边的节点

    private boolean judge(TreeNode curr){
        if(curr.left!=null){
            Stack<TreeNode> stack=new Stack<>();
            stack.push(curr.left);
            while(!stack.empty()){
                TreeNode cur=stack.pop();
                if(cur.val>=curr.val)
                    return false;
                if(cur.left!=null)
                    stack.push(cur.left);
                if(cur.right!=null)
                    stack.push(cur.right);
            }
        }
        if(curr.right!=null){
            Stack<TreeNode> stack=new Stack<>();
            stack.push(curr.right);
            while(!stack.empty()){
                TreeNode cur=stack.pop();
                if(cur.val<=curr.val)
                    return false;
                if(cur.left!=null)
                    stack.push(cur.left);
                if(cur.right!=null)
                    stack.push(cur.right);
            }
        }
        return true;
    }

}

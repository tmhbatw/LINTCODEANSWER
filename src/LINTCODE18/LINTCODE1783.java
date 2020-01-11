package LINTCODE18;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LINTCODE1783 {
    /*Description
    * 二叉树的后序遍历
    * challenge你能使用非递归实现么？
    * */

    //借助堆栈的非递归实现方式
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur=stack.pop();
            if(cur.left==null&&cur.right==null)
                result.add(cur.val);
            else{
                TreeNode left=cur.left;
                TreeNode right=cur.right;
                cur.left=null;
                cur.right=null;
                stack.push(cur);
                if(right!=null)
                    stack.push(right);
                if(left!=null)
                    stack.push(left);

            }
        }
        return result;
        // write your code here
    }

    //递归实现
/*    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        postOrder(result,root);
        return result;
        // write your code here
    }

    private void postOrder(List<Integer> result,TreeNode root){
        if(root==null)
            return;
        postOrder(result,root.left);
        postOrder(result,root.right);
        result.add(root.val);

    }*/
}

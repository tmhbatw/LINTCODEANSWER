import datastructure.TreeNode;

import java.util.Stack;

public class Exercise {

    public void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //非递归实现
    public void preOrder2(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            System.out.print(cur.val+" ");
            if(cur.right!=null)
                stack.add(cur.right);
            if(root.left!=null)
                stack.add(cur.left);
        }
    }
}

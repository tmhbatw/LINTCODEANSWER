package LINTCODE7;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE632 {
    /*Description
    * 在二叉树中寻找值最大的节点并返回。
    * */

    public TreeNode maxNode(TreeNode root) {
        if(root==null)
            return null;
        TreeNode max=root;
        Stack<TreeNode> s=new Stack<>();
        s.add(root);
        while(!s.empty()){
            TreeNode cur=s.pop();
            max=cur.val>max.val?cur:max;
            if(cur.left!=null)
                s.push(cur.left);
            if(cur.right!=null)
                s.push(cur.right);
        }
        return max;
        // write your code here
    }
}

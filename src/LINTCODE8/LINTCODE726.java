package LINTCODE8;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE726 {
    /*Description
    * 如果一棵二叉树所有节点都有零个或两个子节点, 那么这棵树为满二叉树. 反过来说, 满二叉树中不存在只有一个子节点的节点.
    * */


    public boolean isFullTree(TreeNode root) {
        if(root==null)
            return true;
        return recursion(root);
        // write your code here
    }
    private boolean recursion(TreeNode cur){
        if(cur.left==null&&cur.right==null)
            return true;
        if(cur.left!=null&&cur.right!=null){
            return recursion(cur.left)&&recursion(cur.right);
        }
        return false;

    }
/*    public boolean isFullTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null&&cur.right!=null){
                queue.add(cur.left);
                queue.add(cur.right);
            }else if(cur.left!=null||cur.right!=null){
                return false;
            }
        }
        return true;
        // write your code here
    }*/
}

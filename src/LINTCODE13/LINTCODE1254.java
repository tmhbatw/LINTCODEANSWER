package LINTCODE13;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1254 {
    /*Description
    *找出给定二叉树中，所有左叶子的值之和。
    * */

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null);
        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        root.val=0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left==null&&cur.right==null)
                res+=cur.val;
            if(cur.right!=null){
                cur.right.val=0;
                queue.add(cur.right);
            }if(cur.left!=null){
                queue.add(cur.left);
            }
        }
        return res;
        // Write your code here
    }
}

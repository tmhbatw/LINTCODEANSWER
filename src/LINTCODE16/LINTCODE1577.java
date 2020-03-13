package LINTCODE16;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1577 {
    /*Description
    * 给个一颗二叉树，求出所有叶节点的和。要求使用O(1)的空间
    * */

    public int sumLeafNode(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=0;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left==null&&cur.right==null)
                result+=cur.val;
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        return result;
        // Write your code here
    }
}

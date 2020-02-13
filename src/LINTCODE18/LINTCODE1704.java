package LINTCODE18;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1704 {
    /*Description
    * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
    * 二叉搜索树保证具有唯一的值。
    * */

    public int rangeSumBST(TreeNode root, int L, int R) {
        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur==null)
                continue;
            if(cur.val>R)
                queue.add(cur.left);
            else if(cur.val<L)
                queue.add(cur.right);
            else {
                result += cur.val;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return result;
        // write your code here.
    }
}

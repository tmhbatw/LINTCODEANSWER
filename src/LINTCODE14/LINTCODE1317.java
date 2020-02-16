package LINTCODE14;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1317 {
    /*Description
    * 给定一棵完全二叉树，计算它的节点数。
    * */

    public int countNodes(TreeNode root) {
        int result=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left==null)
                return result;
            if(cur.right==null)
                return result+1;
            queue.add(cur.left);
            queue.add(cur.right);
            result+=2;
        }
        return result;
        // write your code here
    }
}

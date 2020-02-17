package LINTCODE12;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1197 {
    /*Description
    * 给定一棵二叉树，找到这棵树最中最后一行中最左边的值。
    * */

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            result=queue.peek().val;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        return result;
        // write your code here
    }
}

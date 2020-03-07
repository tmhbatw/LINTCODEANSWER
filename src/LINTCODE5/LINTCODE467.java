package LINTCODE5;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE467 {
    /*Description
    * 判断一个二叉树是否是完全二叉树
    * */

    public boolean isComplete(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int time=1;
        boolean flag=false;
        while(!queue.isEmpty()){
            if(queue.size()!=time)
                flag=true;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(flag){
                    if(cur.left!=null||cur.right!=null)
                        return false;
                }
                if(cur.left==null&&cur.right!=null)
                    return false;
                if(cur.left==null||cur.right==null){
                    flag=true;
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            time*=2;
        }
        return true;
        // write your code here
    }

}

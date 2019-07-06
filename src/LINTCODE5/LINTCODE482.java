package LINTCODE5;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE482 {
    /*Description
    * 给出一棵二叉树和一个整数代表树的某层深度。
    * 计算二叉树的某层节点之和。
    * */

    /*Solution
    * bfs
    * */

    public int levelSum(TreeNode root, int level) {
        if(root==null||level==0)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=0;i<level-1;i++){
            int size=queue.size();
            while(size-->0){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        int result=0;
        while(!queue.isEmpty()){
            result+=queue.poll().val;
        }
        return result;
        // write your code here
    }

}

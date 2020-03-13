package LINTCODE10;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE939 {
    /*Description
    * 返回给定二叉树第 K 层(层序号从 1 开始，根节点为第1层)的节点数量。
    * */

        public int kthfloorNode(TreeNode root, int k) {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int time=1;
            while (!queue.isEmpty()){
                int size=queue.size();
                if(time==k)
                    return size;
                time++;
                for(int i=0;i<size;i++){
                    TreeNode cur=queue.poll();
                    if(cur.right!=null)
                        queue.add(cur.right);
                    if(cur.left!=null)
                        queue.add(cur.left);
                }
            }
            return -1;
            // Write your code here
        }
}

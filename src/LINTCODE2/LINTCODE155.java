package LINTCODE2;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE155 {
    /*Description
    * Given a binary tree, find its minimum depth.
    * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    * */


    /*Solution
    * 可以使用bfs宽度优先搜索
    * */

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int step=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            step++;
            for(int i=0;i<size;i++) {

                TreeNode curr = queue.poll();
                if (curr.right == null & curr.left == null)
                    return step;
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }
        return step;
        // write your code here
    }
}

package LINTCODE5;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE481 {
    /*Description
    * Given a binary tree, calculate the sum of leaves.
    * */

    /*Solution
    * 将每一个节点保存在一个数据结构中即可
    * 当当前节点左右子节点为null时，将他的val值加入结果中
    * */

    public int leafSum(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        Integer result=0;
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null)
                queue.add(curr.left);
            if(curr.right!=null)
                queue.add(curr.right);
            if(curr.left==null&&curr.right==null)
            result+=curr.val;
        }
        return result;
        // write your code here
    }
}

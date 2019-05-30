package LINTCODE1;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE97 {
    /*Description
    *Given a binary tree, find its maximum depth.
    * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    * */

    /*Solution
    * 使用一个双向队列保存树遍历即可
    * */

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        int result=0;
        while(!stack.isEmpty()){
            result++;
            int size=stack.size();
            for (int i=0;i<size;i++){
                TreeNode curr=stack.pollLast();
                if(curr.right!=null)
                    stack.push(curr.right);
                if(curr.left!=null)
                    stack.push(curr.left);
            }
        }
        return result;



        // write your code here
    }
}

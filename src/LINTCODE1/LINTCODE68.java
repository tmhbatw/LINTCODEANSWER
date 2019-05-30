package LINTCODE1;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE68 {
    /*Description
     *Given a binary tree, return the postorder traversal of its nodes' values.
     * Challenge
     * Can you do it without recursion?
     * */

    /*Solution
     * 与66题思路基本一致，搞清输出顺序即可
     * */

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pollLast();
            if(curr.left!=null){
                TreeNode left=curr.left;
                curr.left=null;
                stack.addLast(curr);
                stack.addLast(left);
            }else if(curr.right!=null){
                TreeNode right=curr.right;
                curr.right=null;
                stack.addLast(curr);
                stack.addLast(right);
            }else{
                result.add(curr.val);
            }
        }
        return result;
        // write your code here
    }
}

package LINTCODE11;

import datastructure.TreeNode;

public class LINTCODE1085 {
    /*Description
    * 给定一颗二叉树，找到路径中每个节点具有相同值的最长路径的长度。 此路径可能会也可能不会通过根节点。
    * */

    static int result=0;
    public int longestUnivaluePath(TreeNode root) {
        recursion(root);
        return result-1;
        // Write your code here
    }

    private int recursion(TreeNode root){
        if(root==null)
            return 0;
        int left=recursion(root.left);
        int right=recursion(root.right);
        left=root.left!=null&&root.val==root.left.val?left:0;
        right=root.right!=null&&root.val==root.right.val?right:0;
        result=Math.max(result,left+right+1);
        System.out.println(root.val+"  "+result);
        return Math.max(left,right)+1;
    }

}

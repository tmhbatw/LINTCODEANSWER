package LINTCODE15;

import datastructure.TreeNode;

public class LINTCODE1482 {
    /*Description
    * 给一棵BST, 找到从根节点到叶子节点的最小路径和
    * */

    public int minimumSum(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null&&root.right!=null) {
            return Math.min(minimumSum(root.left), minimumSum((root.right))) + root.val;
        }
        if(root.left==null&&root.right==null)
            return root.val;
        if(root.right==null)
            return minimumSum(root.left)+root.val;
        return minimumSum(root.right)+root.val;
        // Write your code here
    }
}

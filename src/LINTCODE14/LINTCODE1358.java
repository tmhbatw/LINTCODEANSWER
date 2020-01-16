package LINTCODE14;

import datastructure.TreeNode;

public class LINTCODE1358 {
    /*Description
    * 给定二叉树和求和，确定树是否具有根到叶路径，使得沿路径的所有值相加等于给定的总和。
    * */

    public boolean pathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null&&root.val==sum)
            return true;
        return pathSum(root.left,sum-root.val)||pathSum(root.right,sum-root.val);
        // Write your code here.
    }
}

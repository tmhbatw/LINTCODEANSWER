package LINTCODE11;

import datastructure.TreeNode;

public class LINTCODE1094 {
    /*Description
    * 给定一个非空的特别的结点包含非负值二叉树，其中树中的每一个节点包含正好两个或者零个子结点。
    * 如果这个结点有两个子结点，那么这个结点的值不大于它的两个子结点。
    * 对于这样一个二叉树，你需要输出由整个树当中的结点值构成的集合中的次小值。
    * 如果不存在这样的一个次小值，输出-1作为替代。
    * */

    public int findSecondMinimumValue(TreeNode root) {
        if(root==null||root.left==null)
            return -1;
        int left=root.left.val;
        int right=root.right.val;
        if(left>root.val&&right>root.val)
            return Math.min(left,right);
        if(left==root.val&&right>root.val)
            return right;
        if(right==root.val&&left>root.val)
            return left;
        right=findSecondMinimumValue(root.right);
        left=findSecondMinimumValue(root.left);
        if(left==-1)
            return right;
        if(right==-1)
            return left;
        return Math.min(right,left);
        // Write your code here
    }
}

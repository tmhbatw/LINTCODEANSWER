package LINTCODE6;

import datastructure.TreeNode;

public class LINTCODE596 {
    /*Description
    * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。输入输出数据范围都在int内。
    * */

    int min=Integer.MAX_VALUE;
    TreeNode result=null;

    public TreeNode findSubtree(TreeNode root) {
        getValue(root);
        return result;
        // write your code here
    }

    private int getValue(TreeNode root){
        if(root==null)
            return 0;
        int cur=root.val+getValue(root.left)+getValue(root.right);
        if(cur<min){
            min=cur;
            result=root;
        }
        return cur;
    }
}

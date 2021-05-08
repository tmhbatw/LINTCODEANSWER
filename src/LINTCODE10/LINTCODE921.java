package LINTCODE10;

import datastructure.TreeNode;

public class LINTCODE921 {
    /*Description
    * 给定一棵二叉树，统计唯一值子树的数目.
    * 唯一值子树意味着子树的所有节点都具有相同的值.
    * */

    private int result =0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        isSameTree(root);
        return result;
        // write your code here
    }

    private boolean isSameTree(TreeNode root){
        if(root==null)
            return true;
        int val=root.val;
        boolean isLeftSame=isSameTree(root.left);
        boolean isRightSame=isSameTree(root.left);
        if(isLeftSame&&isRightSame&&(root.left==null||root.left.val==val)&&(root.right==null||root.right.val==val)){
            result++;
            return true;
        }
        return false;
    }
}

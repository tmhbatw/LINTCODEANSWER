package LINTCODE5;

import datastructure.TreeNode;

public class LINTCODE475 {
    /*Description
    * 给一棵二叉树，找出从根节点出发的路径中，和最大的一条。
    * 这条路径可以在任何二叉树中的节点结束，但是必须包含至少一个点（也就是根了）。
    * */

    public int maxPathSum2(TreeNode root) {
        if(root==null)
            return 0;
        int left=maxPathSum2(root.left);
        int right=maxPathSum2(root.right);
        if(left<0&&right<0) {
            return root.val;
        }
        return root.val+Math.max(left,right);
        // write your code here
    }
}

package LINTCODE14;

import datastructure.TreeNode;

public class LINTCODE1311 {
    /*Description
    * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min=Math.min(p.val,q.val);
        int max=Math.max(p.val,q.val);
        return getAncestor(root,min,max);
        // write your code here
    }

    private TreeNode getAncestor(TreeNode root,int min,int max){
        if(root.val==min||root.val==max||root.val<max&&root.val>min)
            return root;
        if(root.val<min)
            return getAncestor(root.right,min,max);
        return getAncestor(root.left,min,max);
    }
}

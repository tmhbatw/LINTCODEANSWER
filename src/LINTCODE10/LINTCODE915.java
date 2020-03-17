package LINTCODE10;

import datastructure.TreeNode;

public class LINTCODE915 {
    /*Description
    *给出一棵二叉搜索树以及其中的一个节点，找到这个节点在这棵树中的中序前驱节点。
    * */

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if(p==null)
            return null;
        return function(root,null,p.val);
        // write your code here
    }

    private TreeNode function(TreeNode root,TreeNode pre,int target){
        if(root.val>target)
            return function(root.left,pre,target);
        if(root.val==target) {
            if(root.left==null)
                return pre;
            root=root.left;
            while(root.right!=null)
                root=root.right;
            return root;
        }
        return function(root.right,root,target);
    }

}

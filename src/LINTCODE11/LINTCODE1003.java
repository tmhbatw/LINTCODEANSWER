package LINTCODE11;

import datastructure.TreeNode;

public class LINTCODE1003 {
    /*Description
    * 给定二叉树的根节点，树上每个节点的值是0或1。
    * 返回这棵树，其中每个不包含1的子树已被删除。
    * （注意，节点X的子树是X，加上X的所有子孙节点。）
    * */

    /*Solution
    * 先减左边和右边，剪完后减去root节点
    * */

    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.val==0&&root.left==null&&root.right==null)
            return null;
        return root;
        // Write your code here
    }
}

package LINTCODE;

import datastructure.TreeNode;

public class LINTCODE88 {
    /*Description
    * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    * */

    /*Solution
    * 遍历到某一根节点时，当根节点的值与A或B相等，那么根节点必为公共祖先
    * 遍历该根节点左右两节点，如果左右两节点均有值，那么根节点为公共节点
    * 若左右两结点有一个为空，证明两节点均在那一节点下，返回那一节点
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root==null||root.val==A.val||root.val==B.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root,A,B);
        TreeNode right=lowestCommonAncestor(root,A,B);
        if(left!=null&&right!=null){
            return root;
        }else if(left==null)
            return right;
        else
            return left;
        // write your code here
    }

}

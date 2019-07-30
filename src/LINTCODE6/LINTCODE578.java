package LINTCODE6;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE578 {
    /*Description
    * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
    * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
    * 返回 null 如果两个节点在这棵树上不存在最近公共祖先的话。
    * */

    /*Solution
    * 递归
    * */
        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
            if(!containsNode(root,A)||!containsNode(root,B))
                return null;
            if(root.val==A.val||root.val==B.val||containsNode(root.left,A)&&containsNode(root.right,B)||containsNode(root.right,A)&&containsNode(root.left,B))
                return root;
            if(containsNode(root.left,A))
                return lowestCommonAncestor3(root.left,A,B);
            else
                return lowestCommonAncestor3(root.right,A,B);

            // write your code here
        }

        private boolean containsNode(TreeNode root,TreeNode cur){
            if(root==null)
                return false;
            if(root.val==cur.val)
                return true;
            return containsNode(root.left,cur)||containsNode(root.right,cur);
        }
}

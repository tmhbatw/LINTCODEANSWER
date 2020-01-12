package LINTCODE12;

import datastructure.TreeNode;

public class LINTCODE1126 {
    /*Description
    * 给出两棵二叉树，当你用其中一棵覆盖另一棵时，两棵树的一些节点会发生重叠，而其他节点则不会重叠。
    * 您需要将它们合并到一棵新的二叉树中。 合并的规则是如果两个节点重叠，则将节点值加起来作为合并节点的新值。 否则，非空的节点将用作新树的节点。
    * */


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        TreeNode result=new TreeNode (t1.val+t2.val);
        result.left=mergeTrees(t1.left,t2.left);
        result.right=mergeTrees(t1.right, t2.right);
        return result;
        // Write your code here
    }


}

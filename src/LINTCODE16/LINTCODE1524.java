package LINTCODE16;

import datastructure.TreeNode;

public class LINTCODE1524 {
    /*Description
    * 给定一颗二叉搜索树和 value.
    * 返回这棵树中值等于 value 的节点. 如果不存在这样的节点, 返回 null.
    * */

    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null&&root.val!=val){
            if(root.val>val)
                root=root.left;
            else
                root=root.right;
        }
        return root;
        // Write your code here.
    }
}

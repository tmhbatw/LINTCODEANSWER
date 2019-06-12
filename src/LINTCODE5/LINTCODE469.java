package LINTCODE5;

import datastructure.TreeNode;

public class LINTCODE469 {
    /*Description
    *检查两棵二叉树是否等价。等价的意思是说，首先两棵二叉树必须拥有相同的结构，并且每个对应位置上的节点上的数都相等。
    * */

    /*Solution
    * 递归比较即可
    * */

    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a==null&&b==null)
            return true;
        if(a==null||b==null||a.val!=b.val)
            return false;
        return isIdentical(a.left,b.left)&&isIdentical(a.right,b.right);
        // write your code here
    }
}

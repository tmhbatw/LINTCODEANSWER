package LINTCODE5;

import datastructure.TreeNode;

public class LINTCODE470 {

    /*Description
    * 检查两棵二叉树是否在经过若干次扭转后可以等价。扭转的定义是，交换任意节点的左右子树。等价的定义是，两棵二叉树必须为相同的结构，并且对应位置上的节点的值要相等。
    * */

    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if(a==null&&b==null){
            return true;
        }
        if(a==null||b==null||a.val!=b.val){
            return false;
        }
        return isTweakedIdentical(a.left,b.left)&&isTweakedIdentical(a.right,b.right)||
                (isTweakedIdentical(a.right,b.left)&&isTweakedIdentical(a.left,b.right));
        // write your code here
    }
}

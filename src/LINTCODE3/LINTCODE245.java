package LINTCODE3;

import datastructure.TreeNode;

public class LINTCODE245 {
    /*Description
    * 有两个不同大小的二叉树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
    * */

    /*Solution
    * 递归遍历求解
    * 首先找到子节点在父节点中的位置，找到之后遍历比较两节点的左右节点，比较是否完全相等
    * 需要注意的是树中有可能存在值相同的节点
    * */

    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if(T2==null)
            return true;
        if(T1==null)
            return false;
        if(T1.val==T2.val){
            boolean flag= isSame(T1.right,T2.right)&&isSame(T1.left,T2.left);
            if(flag==true)
                return true;
        }
        return isSubtree(T1.left,T2)||isSubtree(T1.right,T2);
        // write your code here
    }

    public boolean isSame(TreeNode T1,TreeNode T2){
        if(T1==null&&T2==null)
            return true;
        if(T1==null||T2==null||T1.val!=T2.val)
            return false;
        return isSame(T1.left,T2.left)&&isSame(T1.right,T2.right);

    }
}

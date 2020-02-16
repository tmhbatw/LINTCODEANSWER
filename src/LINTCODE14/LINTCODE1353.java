package LINTCODE14;

import datastructure.TreeNode;

public class LINTCODE1353 {
    /*Description
    *给定仅包含来自0-9的数字的二叉树，每个根到叶路径可以表示数字。举个例子：
    * root-to-leaf路径1-> 2-> 3，它代表数字123，找到所有根到叶的数的总和
    * */

    private int result=0;

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        recursion(root,0);
        return result;
        // write your code here
    }

    private void recursion(TreeNode cur,int preSum){
        int curSum=preSum*10+cur.val;
        if(cur.left==null&&cur.right==null)
            result+=curSum;
        if(cur.left!=null)
            recursion(cur.left,curSum);
        if(cur.right!=null)
            recursion(cur.right,curSum);
    }
}

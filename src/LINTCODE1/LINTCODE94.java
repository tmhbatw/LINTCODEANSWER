package LINTCODE1;

import datastructure.TreeNode;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class LINTCODE94 {
    /*Description
    *Given a binary tree, find the maximum path sum.
    * The path may start and end at any node in the tree.
    * */

    /*Solution
    * 使用递归方法
    * 含有当前节点的最大权值为左右两子节点最大值与当前节点的和
    * 将这个值与result进行比较，result保存较大的值
    * 创建的函数用来返回含有当前节点以及某一边的权值
    * */

    private int res=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        recursion(root);
        return res;
        // write your code here
    }
    private int recursion(TreeNode root){
        if(root==null)
            return 0;
        int left=Math.max(recursion(root.left),0);
        int right=Math.max(recursion(root.right),0);
        res=Math.max(left+right+root.val,res);
        return Math.max(left,right)+root.val;
    }
}

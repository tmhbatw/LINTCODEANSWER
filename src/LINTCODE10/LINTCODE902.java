package LINTCODE10;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE902 {
    /*Description
    * 给一棵二叉搜索树，写一个 KthSmallest 函数来找到其中第 K 小的元素。
    * */

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null){
            stack.add(root);
            root=root.left;
        }
        int result=0;
        while(k-->0){
            TreeNode cur=stack.pop();
            result=cur.val;
            cur=cur.right;
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
        }
        return result;
        // write your code here
    }
}

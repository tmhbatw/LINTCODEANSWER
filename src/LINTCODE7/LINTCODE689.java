package LINTCODE7;

import datastructure.ListNode;
import datastructure.TreeNode;

public class LINTCODE689 {
    /*Description
    *给一棵二叉搜索树以及一个整数 n, 在树中找到和为 n 的两个数字
    * */

    public int[] twoSum(TreeNode root, int n) {
        if(root==null)
            return null;
        //获取最左边的那个
        TreeNode left=root;
        while(left.left!=null)
            left=left.left;
        //获取最右边的那个
        TreeNode right=root;
        while(right.right!=null)
            right=right.right;
        while(left!=right){
            int curSum=left.val+right.val;
            if(curSum==n)
                return new int[]{left.val,right.val};
            if(curSum<n){
                left=findBigger(root,left.val);
            }else{
                right=findSmaller(root,right.val);
            }
        }
        return null;
        // write your code here
    }
    private TreeNode findBigger(TreeNode root,int val){
        if(root==null)
            return null;
        if(root.val<=val)
            return findBigger(root.right,val);
        else {
            TreeNode cur=findBigger(root.left,val);
            if(cur==null)
                return root;
            return cur;
        }
    }

    private TreeNode findSmaller(TreeNode root,int val){
        if(root==null)
            return null;
        if(root.val>=val)
            return findSmaller(root.left,val);
        else{
            TreeNode cur=findSmaller(root.right,val);
            if(cur==null)
                return root;
            return cur;
        }
    }
}

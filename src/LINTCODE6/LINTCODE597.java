package LINTCODE6;

import datastructure.TreeNode;

public class LINTCODE597 {
    /*Description
    *给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
    * */

    double max=Integer.MIN_VALUE;
    TreeNode result;

    public TreeNode findSubtree2(TreeNode root) {
        getValue(root);
        return result;
        // write your code here
    }

    private int[] getValue(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int[] left=getValue(root.left);
        int[] right=getValue(root.right);
        int curSum=left[0]+right[0]+root.val;
        int curNumber=left[1]+right[1]+1;
        double cur=1.0*curSum/curNumber;
        if(cur>max){
            max=cur;
            result=root;
        }
        return new int[]{curSum,curNumber};
    }

}

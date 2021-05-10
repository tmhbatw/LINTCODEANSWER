package LINTCODE10;

import datastructure.TreeNode;

public class LINTCODE910 {
    /*Description
    * 给定一棵二叉树，找到是二叉搜索树的最大子树，最大子树定义为子树节点最多。
    * */

    int result=0;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return result;
        // Write your code here
    }

    //返回一个三位数组，第一位存储二叉搜索树的大小，第二位存储最大值，第三位存储最小值
    private int[] dfs(TreeNode root){
        if(root.left==null&&root.right==null)
            return new int[]{1,root.val,root.val};
        if(root.left==null){
            int[] right=dfs(root.right);
            if(right[0]==1&&root.val<root.right.val) {
                result=Math.max(result,2);
                return new int[]{2, root.right.val, root.val};
            }
            return new int[]{0,0,0};
        }
        if(root.right==null){
            int[] left=dfs(root.left);
            if(left[0]==1&&root.val>root.left.val) {
                result=Math.max(result,2);
                return new int[]{2, root.val, root.left.val};
            }
            return new int[]{0,0,0};
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        if(left[0]==0||right[0]==0||left[1]>=root.val||right[2]<=root.val)
            return new int[]{0,0,0};
        result=Math.max(result,1+left[0]+right[0]);
        return new int[]{1+left[0]+right[0],right[1],left[2]};
    }
}

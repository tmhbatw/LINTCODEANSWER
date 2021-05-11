package LINTCODE9;

import datastructure.TreeNode;

public class LINTCODE864 {
    /*Description
    * 给定一个有 n个节点的二叉树，请问可否在去掉恰好一条边的情况下，将原有的树分成两个节点值总和相等的两个树。
    * */

    boolean result=false;
    int sum;
    public boolean checkEqualTree(TreeNode root) {
        if(root==null)
            return false;
        sum=getSum(root);
        if(sum%2==1)
            return false;
        sum/=2;
        dfs(root);
        return result;
        // write your code here
    }

    private int getSum(TreeNode root){
        if(root==null)
            return 0;
        return root.val+getSum(root.left)+getSum(root.right);
    }

    private int dfs(TreeNode root){
        if(result)
            return 0;
        int val=root.val;
        if(root.left!=null){
            int leftVal=dfs(root.left);
            if(leftVal==sum){
                result=true;
                return 0;
            }
            val+=leftVal;
        }
        if(root.right!=null){
            int rightVal=dfs(root.right);
            if(rightVal==sum){
                result=true;
                return 0;
            }
            val+=rightVal;
        }
        return val;
    }
}

package LINTCODE3;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE246 {
    /*Description
    *给一棵二叉树和一个目标值，设计一个算法找到二叉树上的和为该目标值的所有路径。路径可以从任何节点出发和结束，
    * 但是需要是一条一直往下走的路线。也就是说，路径上的节点的层级是逐个递增的
    * */

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        recursion(result,target,root);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,int target,TreeNode root){
        if(root==null)
            return;
        recursion(result,target,root.left);
        recursion(result,target,root.right);
        recursion2(result,new ArrayList<>(),0,target,root);
    }

    private void recursion2(List<List<Integer>> result,List<Integer> res,int curSum,int target,TreeNode root){
        if(root==null)
            return;
        List<Integer> curRes=new ArrayList<>(res);
        curRes.add(root.val);
        curSum+=root.val;
        if(curSum==target)
            result.add(curRes);
        recursion2(result,curRes,curSum,target,root.left);
        recursion2(result,curRes,curSum,target,root.right);
    }
}

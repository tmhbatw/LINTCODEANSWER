package LINTCODE14;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1357 {
    /*Description
    * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    * */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),sum,root);
        return result;
        // Write your code here.
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int sum,TreeNode cur){
        if(cur.val>sum)
            return;
        if(cur.val==sum&&cur.left==null&&cur.right==null){
            res.add(cur.val);
            result.add(res);
            return ;
        }
        if(cur.left!=null) {
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(cur.val);
            recursion(result,curRes,sum-cur.val,cur.left);
        }
        if(cur.right!=null){
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(cur.val);
            recursion(result,curRes,sum-cur.val,cur.right);
        }
    }
}

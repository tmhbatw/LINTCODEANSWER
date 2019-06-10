package LINTCODE4;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE376 {

    /*Description
    *Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
    * A valid path is from root node to any of the leaf nodes.
    * */

    /*Solution
    * 第一时间想到的应该是递归遍历，遍历每一条路劲判断是否能够达到目标值
    * 可行
    * */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if(root==null){
            return Collections.emptyList();
        }
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        res.add(root.val);
        recursion(result,res,target-root.val,root);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int target,TreeNode node){
        if(target==0&&node.left==null&&node.right==null){
            result.add(res);
            return;
        }
        if(target<=0||node.left==null&&node.right==null){
            return;
        }
        List<Integer> ress=new ArrayList<>();
        ress.addAll(res);
        if(node.left!=null){
            ress.add(node.left.val);
            recursion(result,ress,target-node.val,node.left);
        }
        if(node.right!=null){
            ress.add(node.right.left.val);
            recursion(result,ress,target-node.val,node.right);
        }
    }

/*    private void delete(List<List<Integer>> res){
        for(int i=0;i<res.size();i++){
            for(int j=res.size()-1;j>i;j--){
                if(res.get(i).equals(res.get(j)))
                    res.remove(j);
            }
        }
    }*/
}

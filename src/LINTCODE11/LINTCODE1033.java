package LINTCODE11;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1033 {
    /*Description
    * 给定一个确定根的二叉搜索树，返回树中任意两个不同节点的值的最小差。
    * */

    public int minDiffInBST(TreeNode root) {
        List<Integer> value=new ArrayList<>();
        inOrder(root,value);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<value.size();i++){
            min=Math.min(min,value.get(i)-value.get(i-1));
        }
        return min;
        // Write your code here
    }

    private void inOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}

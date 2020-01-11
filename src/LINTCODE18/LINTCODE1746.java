package LINTCODE18;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LINTCODE1746 {
    /*Description
    * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
    * */

    /*Solution
    * 因为是一个二叉搜索树，所以可以中序遍历获得从小到大排列顺序的数组
    * */

    public int minDiffInBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inOrder(list,root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            min=Math.min(list.get(i)-list.get(i-1),min);
        }
        return min;
        // Write your code here.
    }

    private void inOrder(List<Integer> list,TreeNode root){
        if(root==null)
            return;
        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }
}

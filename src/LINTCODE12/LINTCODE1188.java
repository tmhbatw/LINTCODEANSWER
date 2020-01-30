package LINTCODE12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1188 {
    /*Description
    * 给定具有非负值的二叉搜索树，找到任意两个节点的值之间的最小绝对差值.
    * */

    public int getMinimumDifference(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        getInOrder(root,res);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++)
            result=Math.min(res.get(i)-res.get(i-1),result);
        return result;
        // Write your code here
    }


    private void getInOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        getInOrder(root.left,list);
        list.add(root.val);
        getInOrder(root.right,list);
    }
}

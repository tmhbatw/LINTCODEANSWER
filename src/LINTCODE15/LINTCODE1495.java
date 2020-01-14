package LINTCODE15;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1495 {

    /*Description
    * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
    * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
    * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
    * */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        List<Integer> list1=new ArrayList<>();
        getLeaf(root1,list1);
        List<Integer> list2=new ArrayList<>();
        getLeaf(root2,list2);
        if(list1.size()!=list2.size())
            return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i))
                return false;
        }
        return true;
        // write your code here.
    }


    private void getLeaf(TreeNode root1,List<Integer> list){
        if(root1.left==null&&root1.right==null) {
            list.add(root1.val);
            return;
        }
        if(root1.left!=null){
            getLeaf(root1.left,list);
        }
        if(root1.right!=null)
            getLeaf(root1.right,list);
    }
}

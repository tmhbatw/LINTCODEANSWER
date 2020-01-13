package LINTCODE12;

import datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LINTCODE1106 {

    /*Description
    *给定一个没有重复元素的整数数组。根据此数组构建的最大二叉树定义如下：
    * root是数组中的最大数字。
    * 左子树是根据最大数字左侧的子数组构建的最大二叉树。
    * 右子树是根据最大数字右侧的子数组构建的最大二叉树。
    * 通过给定的数组构造最大二叉树并返回此树的根节点。
    * */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
        // Write your code here
    }

    private TreeNode constructMaximumBinaryTree(int[] nums,int start,int end){
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start]);
        int maxIndex=start;
        int max=nums[start];
        for(int i=start+1;i<=end;i++){
            if(nums[i]>max){
                maxIndex=i;
                max=nums[i];
            }
        }
        TreeNode result=new TreeNode(nums[maxIndex]);
        result.left=constructMaximumBinaryTree(nums,start,maxIndex-1);
        result.right=constructMaximumBinaryTree(nums,maxIndex+1,end);
        return result;
    }
}

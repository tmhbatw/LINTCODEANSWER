package LINTCODE14;

import datastructure.TreeNode;

public class LINTCODE1359 {
    /*Description
    *给定一个数组，其中元素按升序排序，将其转换为高度平衡的BST。
    * 对于这个问题，高度平衡的二叉树被定义为二叉树，其中每个节点的两个子树的深度从不相差超过1。
    * */

    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        return convert(nums,0,nums.length-1);
        // Write your code here.
    }

    private TreeNode convert(int[] nums,int left,int right){
        if(left>right)
            return null;
        if(left==right)
            return new TreeNode(nums[left]);
        int mid=left+(right-left)/2;
        TreeNode result=new TreeNode(nums[mid]);
        result.left=convert(nums,left,mid-1);
        result.right=convert(nums,mid+1,right);
        return result;
    }
}

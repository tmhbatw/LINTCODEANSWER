package LINTCODE2;

import datastructure.TreeNode;

public class LINTCODE177 {
    /*Description
    * 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。
    * */

    /*Solution
    * 递归构建二叉树即可
    * */

    public TreeNode sortedArrayToBST(int[] A) {
        TreeNode result=recursion(A,0,A.length-1);
        return result;
        // write your code here
    }

    public TreeNode recursion(int[] nums,int start,int end){
        if(start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=recursion(nums,start,mid-1);
        root.right=recursion(nums,mid+1,end);
        return root;
    }
}

package LINTCODE;

import datastructure.TreeNode;

public class LINTCODE72 {
    /*Description
    *Given inorder and postorder traversal of a tree, construct the binary tree.
    * */

    /*Solution
    *后序遍历的最后一个点为根节点，在中序中找到这个节点
    * 则该节点左边为左节点，右边为右节点
    * 进行递归即可
    * */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        return get(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        // write your code here
    }

    private TreeNode get(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend){
        if(instart>inend)
            return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int index=findIndex(inorder,instart,inend,postorder[postorder.length-1]);
        root.left=get(inorder,instart,index-1,postorder,poststart,poststart+(index-1-instart));
        System.out.println((index+1)+"   "+(inend));
        System.out.println((postend-1-(inend-index-1))+"   "+(postend-1));
        root.right=get(inorder,index+1,inend,postorder,postend-1-(inend-index-1),postend-1);
        return root;
    }


    //用来获取根节点的坐标
    private int findIndex(int[] inorder,int start,int end,int key){
        for(int i=start;i<=end;i++){
            if(inorder[i]==key)
                return i;
        }
        return -1;
    }
}

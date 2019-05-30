package LINTCODE1;

import datastructure.TreeNode;

public class LINTCODE73 {
    /*Description
    * Given preorder and inorder traversal of a tree, construct the binary tree.
    * */

    /*Solution
    * 思路与72题基本相同
    * */


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length)
            return null;
        return getTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        // write your code here
    }

    private TreeNode getTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(instart<inend)
            return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int index=find(inorder,instart,inend,preorder[prestart]);
        root.left=getTree(preorder,prestart+1,prestart+index-instart,inorder,instart,index-1);
        root.right=getTree(preorder,preend-(inend-index-1),preend,inorder,index+1,inend);
        return root;

    }

    private int find(int[] array,int start,int end,int key){
        for(int i=start;i<=end;i++){
            if(array[i]==key)
                return i;
        }
        return -1;
    }
}

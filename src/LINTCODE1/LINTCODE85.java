package LINTCODE1;

import datastructure.TreeNode;

public class LINTCODE85 {

    /*Description
    * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
    * */

    /*Solution
    *比较加入节点与根节点大小，向左或向右遍历直到当前节点为空即可
    * */

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root==null)
            return node;
        if(node==null)
            return root;
        TreeNode curr=root;
        int val=node.val;
        while(true){
            if(curr.val>val){
                if(curr.left==null){
                    curr.left=node;
                    break;
                }else{
                    curr=curr.left;
                    continue;
                }
            }else{
                if(curr.right==null){
                    curr.right=node;
                    break;
                }else{
                    curr=curr.right;
                    break;
                }
            }

        }
        return root;
        // write your code here
    }
}

package LINTCODE;

import datastructure.TreeNode;

public class LINTCODE87 {
    /*Description
    * Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary
    * search tree, do nothing. You should keep the tree still a binary search tree after removal.
    *
    * */

    /*Solution
    * 找到目标节点，将目标节点与最近近其值的子节点交换位置
    * 删除目标节点即可；
    * */
    public TreeNode removeNode(TreeNode root, int value) {
        //找到目标二叉树结点
        TreeNode result=new TreeNode(Integer.MAX_VALUE);
        result.left=root;
        TreeNode father=findTarget(result,value);
        if(father==null)
            return result.left;
        changeResult(father,father.val>value);
        return result.left;
        // write your code here
    }

    private void changeResult(TreeNode curr,boolean left){
        TreeNode delete=left?curr.left:curr.right;
        if(delete.left==null&&delete.right==null){
            if(left)
                curr.left=null;
            else
                curr.right=null;
            return;
        }
        else if(delete.left!=null){
            TreeNode lef=delete.left;
            TreeNode leff=delete;
            while(lef.right!=null){
                leff=lef;
                lef=lef.right;
            }
            delete.val=lef.val;
            leff.right=lef.left;
        }else{
            TreeNode right=delete.right;
            TreeNode righ=delete;
            while(right.left!=null){
                righ=right;
                right=right.left;
            }
            delete.val=right.val;
            righ.left=right.right;
        }

    }

    private TreeNode findTarget(TreeNode root,int value){
        if(root.val>value){
            if(root.left.val==value)
                return root;
            else if(root.left==null)
                return null;
            else
                return findTarget(root.left,value);
        }else{
            if(root.right.val==value)
                return root;
            else if(root.right==null)
                return null;
            else
                return findTarget(root.right,value);
        }
    }
}

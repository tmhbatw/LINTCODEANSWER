package LINTCODE13;

import datastructure.TreeNode;

public class LINTCODE1234 {
    /*Description
    *给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
    * 返回二叉搜索树（有可能被更新）的根节点的引用。
    * 一般来说，删除节点可分为两个步骤：
    * 首先找到需要删除的节点；
    * 如果找到了，删除它。
    * */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key){
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            TreeNode left=root.left;
            TreeNode right=root.right;
            TreeNode l=left.right;
            left.right=right;
            while(right.left!=null)
                right=right.left;
            right.left=l;
            return left;
        }
        delete(root,key);
        return root;
        // write your code here
    }

    private void delete(TreeNode root,int key){
        if(root.val<key){
            if(root.right==null)
                return;
            else if(root.right.val==key){
                TreeNode right=root.right;
                TreeNode l=right.left;
                TreeNode r=right.right;
                if(l==null)
                    root.right=r;
                else if(r==null)
                    root.right=l;
                else{
                    root.right=l;
                    l=l.right;
                    root.right.right=r;
                    while(r.left!=null){
                        r=r.left;
                    }
                    r.left=l;
                }
            }else
                delete(root.right,key);
        }
        if(root.val>key){
            if(root.left==null)
                return;
            else if(root.left.val==key){
                TreeNode left=root.left;
                TreeNode l=left.left;
                TreeNode r=left.right;
                if(l==null)
                    root.left=r;
                else if(r==null)
                    root.left=l;
                else{
                    root.left=l;
                    l=l.right;
                    root.left.right=r;
                    while(r.left!=null){
                        r=r.left;
                    }
                    r.left=l;
                }

            }else
                delete(root.left,key);
        }
    }
}

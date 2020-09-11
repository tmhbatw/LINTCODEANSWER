package LINTCODE12;

import datastructure.TreeNode;

public class LINTCODE1129 {
    /*Description
    *给定一个二叉树。
    * 定义深度是树上的节点到根节点的距离，子树是一个节点和它所有后代节点的集合。
    * 我们将树上的节点中具有最大深度的节点称为 关键节点。
    * 请编写一个程序返回包含所有 关键节点 的最小的子树。
    * */

    public TreeNode subtreeWithAllKeyNodes(TreeNode root) {
        SeniorTreeNode node=getSeniorTreeNode(root);
        while(node.left.height!=node.right.height){
            node=node.left.height>node.right.height?node.left:node.right;
        }
        return node.treeNode;
        // write your code here.
    }

    private SeniorTreeNode getSeniorTreeNode(TreeNode node){
        if(node==null)
            return new SeniorTreeNode(null,0);
        SeniorTreeNode curNode=new SeniorTreeNode(node,0);
        curNode.height=1;
        curNode.left=getSeniorTreeNode(node.left);
        curNode.right=getSeniorTreeNode(node.right);
        curNode.height=Math.max(curNode.left.height,curNode.right.height)+1;
        return curNode;
    }

    private class SeniorTreeNode {
        SeniorTreeNode left;
        SeniorTreeNode right;
        TreeNode treeNode;
        int height;
        public SeniorTreeNode(TreeNode cur,int height){
            this.treeNode=cur;
            this.height=height;
        }
    }
}

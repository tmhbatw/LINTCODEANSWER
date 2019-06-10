package LINTCODE5;

import datastructure.ParentTreeNode;

public class LINTCODE474 {
    /*Description
    *Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
    * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
    * The node has an extra attribute parent which point to the father of itself. The root's parent is null.
    * */

    /*Solution
    * 路程碰撞问题，因为每个节点包含自己的父节点，因此可以是节点从当前节点出发，向父节点运动，走到头时从另一节点开始运动
    * 因为运动路程是相同的，所以一定在某一个时刻会相遇，相遇节点即为公共父节点
    * */

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if(root==null)
            return null;
        ParentTreeNode a=A;
        ParentTreeNode b=B;
        while(a!=b){
            a=a==null?B:a.parent;
            b=b==null?A:b.parent;
        }
        return a;
        // write your code here
    }
}

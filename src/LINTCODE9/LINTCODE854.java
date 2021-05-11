package LINTCODE9;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE854 {
    /*Description
    * 给定一颗二叉树 每一个节点具有不同的值, 和一个目标值 k.
    * 在树中找到距离目标 k最近的节点 .如果存在多个这样的节点, 您应该遵循以下优先顺序：
    * 1、叶节点位于k节点的左子树中；
    * 2、叶节点位于k节点的右子树中；
    * 3、叶节点不在具有k的节点的子树中。
    * */

    TreeNode res=null;
    Map<TreeNode,TreeNode> map;
    int length=Integer.MAX_VALUE;
    Set<TreeNode> set=new HashSet<>();
    public int findClosestLeaf(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode node=null;
        map=new HashMap<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.val==k)
                node=cur;
            if(cur.left!=null){
                map.put(cur.left,cur);
                q.add(cur.left);
            }
            if(cur.right!=null){
                map.put(cur.right,cur);
                q.add(cur.right);
            }
        }
        dfs(node,0);
        return res.val;
        // Write your code here
    }

    private void dfs(TreeNode cur,int curLength){
        if(set.contains(cur)||length<=curLength||cur==null)
            return;
        set.add(cur);
        if(cur.left==null&&cur.right==null){
            res=cur;
            length=curLength;
            return;
        }
        dfs(cur.left,curLength+1);
        dfs(cur.right,curLength+1);
        dfs(map.get(cur),curLength+1);
    }
}

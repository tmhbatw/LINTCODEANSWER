package LINTCODE12;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class LINTCODE1101 {
    /*Description
    * 给定一颗二叉树, 编写一个函数求该树的最大宽度, 即该树每一层的宽度的最大值.
    * 该二叉树具有与满二叉树相同的结构, 但是一些节点为空 null.
    * 二叉树某一层的宽度定义为该层两端节点之间的距离. 注意, 两端节点之间的空节点也算作长度.
    * */

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int result=1;
        Map<TreeNode,Integer> map=new HashMap<TreeNode, Integer>();
        map.put(root,1);
        while(!map.isEmpty()){
            Map<TreeNode,Integer> cur=new HashMap<>();
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(Entry entry:map.entrySet()){
                int id= (int) entry.getValue();
                max=Math.max(max,id);
                min=Math.min(min,id);
                TreeNode treeNode=(TreeNode)entry.getKey();
                if(treeNode.left!=null){
                    cur.put(treeNode.left,id*2);
                }
                if(treeNode.right!=null){
                    cur.put(treeNode.right,id*2+1);
                }
                result=Math.max(result,max-min+1);
                map=cur;
            }
        }
        return result;
        // Write your code here
    }
}

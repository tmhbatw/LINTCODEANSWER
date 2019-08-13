package LINTCODE7;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE651 {
    /*Description
    * 给定二叉树，返回其节点值的垂直遍历顺序。 (即逐列从上到下)。
    * 如果两个节点在同一行和同一列中，则顺序应 从左到右。
    * */

    /*Solution
    * 优化思路，一遍遍历
    * */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        Map<TreeNode,Integer> map=new HashMap<>();
        queue.add(root);
        map.put(root,0);
        int max=0;
        int min=0;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            int index=map.get(cur);
            max=Math.max(max,cur.val);
            min=Math.min(min,cur.val);
            if(cur.left!=null){
                queue.add(cur.left);
                map.put(cur.left,index-1);
            }
            if(cur.right!=null){
                queue.add(cur.right);
                map.put(cur.right,index+1);
            }
        }
        int capacity=max-min+1;
        List<List<Integer>> result=new ArrayList<>(capacity);
        min=-min;
        while(capacity-->0)
            result.add(new ArrayList<>());
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            int index=map.get(cur);
            result.get(index+min).add(cur.val);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        return result;
        // write your code here
    }
}

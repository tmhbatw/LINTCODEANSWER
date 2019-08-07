package LINTCODE7;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE650   {
    /*Description
    * 给定一个二叉树，像这样收集树节点：收集并移除所有叶子，重复，直到树为空。
    * */

    Map<TreeNode,Integer> map=new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        int height=getHeight(root);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<height;i++){
            res.add(new ArrayList<Integer>());
        }
        for(Map.Entry entry : map.entrySet()){
            TreeNode cur= (TreeNode) entry.getKey();
            int val= (int) entry.getValue();
            res.get(val-1).add(cur.val);
        }
        return res;
        // write your code here
    }

    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        else {
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            int cur=Math.max(left,right)+1;
            map.put(root,cur);
            return cur;
        }

    }

}

package LINTCODE12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE1108 {
    /*Description
    * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
    * Two trees are duplicate if they have the same structure with same node values.
    * */

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        save(res,map,root);
        return res;
        // write your code here
    }

    private String save(List<TreeNode> list,HashMap<String,Integer> map,TreeNode root){
        if(root==null)
            return "";
        String cur=root.val+","+save(list,map,root.left)+","+save(list,map,root.left);
        System.out.println(cur);
        if(map.containsKey(cur)&&map.get(cur)==1)
            list.add(root);
        map.put(cur,map.getOrDefault(cur,0)+1);
        return cur;
    }
}

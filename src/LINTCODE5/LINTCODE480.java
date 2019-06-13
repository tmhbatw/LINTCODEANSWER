package LINTCODE5;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE480 {

    /*Description
    *Given a binary tree, return all root-to-leaf paths.
    * */

    /*Solution
    * 递归回溯
    * */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        recursion(result,"",root);
        return result;
        // write your code here
    }
    private void recursion(List<String> result,String res,TreeNode node){
        if(node.left==null&&node.right==null){
            result.add(res+node.val);
            return;
        }
        String ress=res+node.val+"->";
        recursion(result,ress,node.left);
        recursion(result,ress,node.right);
    }
}

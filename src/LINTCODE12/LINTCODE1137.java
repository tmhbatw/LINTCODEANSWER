package LINTCODE12;

import datastructure.TreeNode;

public class LINTCODE1137 {
    /*Description
    * 你需要通过一棵二叉树的先序遍历，构建一个包含括号和整数的字符串。
    * 空结点需要用空括号对"()"来表示。同时你需要忽略掉所有的不影响字符串和原始二叉树一对一映射关系的空括号对。
    * */

    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        return recursion(t);
        // write your code here
    }

    private String recursion(TreeNode root){
        String result="";
        result+=root.val;
        if(root.left!=null){
            result+="("+recursion(root.left)+")";
        }
        if(root.right!=null){
            if(root.left==null)
                result+="()";
            result+="("+recursion(root.right)+")";
        }
        return result;
    }
}

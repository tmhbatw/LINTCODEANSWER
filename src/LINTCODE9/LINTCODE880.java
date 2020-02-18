package LINTCODE9;

import datastructure.TreeNode;

public class LINTCODE880 {
    /*Description
    * 你需要根据一个由括号和整数组成的字符串中构造一颗二叉树。
    * 输入的整个字符串表示一个二叉树。它包含一个整数，以及其后跟随的0~2对括号。该整数表示根的值，而一对括号里的字符串代表一个具有相同结构的子二叉树。
    * 如果一个节点含有子节点，你应该先构造它的左子节点。
    * */

    public TreeNode str2tree(String s) {

        System.out.println(s);
        if(s==null||s.length()==0)
            return null;
        int leftStart=-1;
        int leftEnd=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                leftStart = i;
                int time=1;
                while(time!=0){
                    i++;
                    if(s.charAt(i)=='(')
                        time++;
                    if(s.charAt(i)==')')
                        time--;
                }
                leftEnd=i;
                break;
            }
        }
        if(leftStart==-1)
            return new TreeNode(Integer.parseInt(s));
        TreeNode result=new TreeNode(Integer.parseInt(s.substring(0,leftStart)));
        result.left=str2tree(s.substring(leftStart+1,leftEnd));
        if(leftEnd!=s.length()-1)
            result.right=str2tree(s.substring(leftEnd+2,s.length()-1));
        return result;
        // write your code here
    }
}

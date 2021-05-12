package LINTCODE4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LINTCODE369 {
    /*Description
    * 给定一个字符串数组，它代表一个表达式，返回该表达式的波兰表达式。（去掉括号）
     * */

    class MyTreeNode{
        String val;
        MyTreeNode left;
        MyTreeNode right;
        public MyTreeNode(String val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    //遇到
    public List<String> convertToPN(String[] expression) {
        if(expression==null||expression.length==0)
            return Collections.emptyList();
        Stack<String> stack=new Stack<>();
        Stack<MyTreeNode> node=new Stack<>();
        for(String cur:expression){
            switch (cur){
                case "(":
                    stack.add(cur);
                    break;
                case ")":
                    while(!stack.peek().equals("("))
                        node.add(createTreeNode(stack.pop(),node));
                    stack.pop();
                    break;
                case "+":
                case "-":
                    while(!stack.isEmpty()&&(stack.peek().equals("+")||stack.peek().equals("/")||
                            stack.peek().equals("-")||stack.peek().equals("*"))){
                        node.add(createTreeNode(stack.pop(),node));
                    }
                    stack.add(cur);
                    break;
                case "*":
                case "/":
                    if(!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/"))){
                        node.add(createTreeNode(stack.pop(),node));
                    }
                    stack.add(cur);
                    break;
                default:
                    node.add(new MyTreeNode(cur));
            }
        }
        while(!stack.empty()){
            node.add(createTreeNode(stack.pop(),node));
        }
        if(node.isEmpty())
            return Collections.emptyList();
        MyTreeNode root=node.pop();
        List<String> result=new ArrayList<>();
        dfs(root,result);
        return result;
        // write your code here
    }

    private MyTreeNode createTreeNode(String cur,Stack<MyTreeNode> node){
        MyTreeNode root=new MyTreeNode(cur);
        root.right=node.pop();
        root.left=node.pop();
        return root;
    }

    private void dfs(MyTreeNode root,List<String> result){
        result.add(root.val);
        if(root.left!=null)
            dfs(root.left,result);
        if(root.right!=null)
            dfs(root.right,result);
    }
}

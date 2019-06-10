package LINTCODE4;

import datastructure.ExpressionTreeNode;

import java.util.Stack;

public class LINTCODE367 {

    /*Description
    * 表达树是一个二叉树的结构，用于衡量特定的表达。所有表达树的叶子都有一个数字字符串值。而所有表达树的非叶子都有另一个操作字符串值。
    * 给定一个表达数组，请构造该表达的表达树，并返回该表达树的根。
    * */

    /*Solution
    * 创建一个栈，将字符串中的每一个值压入栈中，字符串中，“+”“-”优先级为1，“*”“/”优先级为2，数字优先级为最大，当检测到括号时给当前节点增加10点优先级（只是为了让括号影响符号之间的顺序）
    * 创建一个新的数据结构，其中包含一个ExpressionTreeNode以及一个value值，其中value值为了保存括号的优先级以及更好的进行比较
    *用一个栈数据结构保存当前的节点，为了维持一个递增栈，若栈顶元素比新来元素val大（或相等），则出栈
    * 若栈为空，则将出栈元素作为新来元素的左节点，并将新来元素加入栈中；若不为空，看新栈顶元素，若新栈顶元素比新来元素val小，则将出栈元素作为新来元素的左孩子，并将新来元素加入栈中；
    * 若新栈顶元素比新来元素val大（或相等），则将出栈元素作为新栈顶元素的右节点，重复2-3，直到栈为空或者栈顶元素比新来元素要小，将新来元素加入栈中
    * */

    class TreeNode{
        int val;
        ExpressionTreeNode node;
        public TreeNode (int val,String s){
            this.val=val;
            this.node=new ExpressionTreeNode(s);
        }
    }

    public ExpressionTreeNode build(String[] expression) {
        if(expression.length==0) {
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        int base=0;
        for(int i=0;i<expression.length;i++){
            if(expression[i].equals("(")){
                base+=10;
                continue;
            }else if(expression[i].equals(")")){
                base-=10;
                continue;
            }
            int val=getPriorith(base,expression[i]);
            TreeNode node=new TreeNode(val,expression[i]);
            while(!stack.empty()&&node.val<=stack.peek().val)
                node.node.left=stack.pop().node;
            if(!stack.empty())
                stack.peek().node.right=node.node;
            stack.push(node);
        }
        TreeNode result=stack.pop();
        while(!stack.empty())
            result=stack.pop();
        return result.node;
        // write your code here+
    }

    private int getPriorith(int base,String curr){
        switch(curr) {
            case "+":
            case "-":
                return base + 1;
            case "*":
            case "/":
                return base + 2;
            default:
                return Integer.MAX_VALUE;
        }
    }
}

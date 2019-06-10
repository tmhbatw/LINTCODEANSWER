package LINTCODE4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LINTCODE370 {
    /*Description
    * 给定一个字符串数组，它代表一个表达式，返回该表达式的逆波兰表达式。（去掉括号）
    * */

    /*Solution
    * 感觉与上一题大同小异
    * 不过省去了一个保存操作数的步骤，直接输出到结果当中即可
    * */

    class Operator{
        int priority;
        String exproeesion;
        public Operator(int priority,String exproeesion){
            this.priority=priority;
            this.exproeesion=exproeesion;
        }
    }

    public List<String> convertToRPN(String[] expression) {
        List<String> result=new ArrayList<>();
        Stack<Operator> stack=new Stack<>();
        int base=0;
        for(String s:expression){
            if(s.equals("(")){
                base+=10;
                continue;
            }else if(s.equals(")")){
                base-=10;
                continue;
            }
            int val=getPriority(base,s);
            if(val==0){
                result.add(s);
                continue;}
            Operator o=new Operator(val,s);
            while(!stack.empty()&&stack.peek().priority>=val){
                result.add(stack.pop().exproeesion);
            }
            stack.push(o);
        }
        while(!stack.empty())
            result.add(stack.pop().exproeesion);
        return result;
        // write your code here
    }

    private int getPriority(int base ,String s){
        switch (s){
            case "+":
            case "-":
                return base+1;
            case "*":
            case "/":
                return base+2;
        }
        return 0;
    }
}

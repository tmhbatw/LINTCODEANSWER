package LINTCODE4;

import java.util.Stack;

public class LINTCODE368 {
    /*Description
    *Given an expression string array, return the final result of this expression
    * */

    /*Solution
    * 用一个栈存储操作符，用另一个栈来存储操作数
    *给操作符一个优先级，将操作符压入栈中，当栈中原有操作符大于当前的操作符优先级，那么将原先操作符弹出进行计算即可
    * 注意括号可以给操作符增加优先级
    *  */

    class Operator{
        int priority;
        String expression;
        public Operator(int priority,String expression){
            this.priority=priority;
            this.expression=expression;
        }
    }

    public int evaluateExpression(String[] expression) {
        if(expression.length==0)
            return 0;
        Stack<Integer> operand=new Stack<>();
        Stack<Operator> operator=new Stack<>();
        int base =0;
        for(String s:expression){
            if(s.equals("(")){
                base+=10;
                continue;
            }else if(s.equals(")")){
                base-=10;
                continue;
            }
            int val=getPriority(base,s);
            if(val==0) {
                operand.push(Integer.parseInt(s));
                continue;
            }
            Operator o=new Operator(val,s);
            while(!operator.empty()&&operator.peek().priority>=val){
                String ss=operator.pop().expression;
                int cal2=operand.pop();
                int cal1=operand.pop();
                operand.push(cal(ss,cal1,cal2));
            }
            operator.push(o);
        }
        while(!operator.empty()){
            String ss=operator.pop().expression;
            int cal2=operand.pop();
            int cal1=operand.pop();
            operand.push(cal(ss,cal1,cal2));
        }
        if(operand.empty())
            return 0;
        return operand.pop();
        // write your code here
    }

    private int cal(String s,int cal1,int cal2){
        if(s.equals("+"))
            return cal1+cal2;
        if(s.equals("-"))
            return cal1-cal2;
        if(s.equals("*"))
            return cal1*cal2;
        return cal1/cal2;
    }

    private int getPriority(int base, String expression){
        switch(expression){
            case "*":
            case "/":
                return base +2;
            case "+":
            case "-":
                return base +1;

        }
        return 0;
    }
}

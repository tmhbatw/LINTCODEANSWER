package LINTCODE5;

import java.util.Stack;

public class LINTCODE424 {

    /*Description
    *Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
   * */

    /*Solution
    * 将数字全部压入栈中，遇到符号时则从栈中读取数据并将求值结果压入栈中
    * */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack =new Stack<>();
        for(String curr:tokens){
            switch(curr){
                case "+":
                case "-":
                case "*":
                case "/":
                    int num2=stack.pop();
                    int num1=stack.pop();
                    stack.push(getCal(num1,num2,curr));
                    break;
                    default:stack.push(Integer.valueOf(curr));
            }
        }
        return stack.pop();
        // write your code here
    }

    private int getCal(int num1,int num2,String operator){
        switch (operator){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return 0;
    }
}

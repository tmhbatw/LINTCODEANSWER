package LINTCODE5;

import java.util.Stack;

public class LINTCODE423 {

    /*Description
    *给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
    * */

    /*Solution
    * 使用一个栈进行匹配即可
    * */

    public boolean isValidParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{
                if(stack.empty()||s.charAt(i)=='}'){
                    if(stack.pop()!='{')
                        return false;
                }else if(stack.empty()||s.charAt(i)==']'){
                    if(stack.pop()!='[')
                        return false;
                }else{
                    if(stack.empty()||stack.pop()!='(')
                        return false;
                }
            }
        }
        return stack.empty();
        // write your code here
    }
}

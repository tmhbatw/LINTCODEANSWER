package LINTCODE2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE193 {

    /*Description
    * Given a string containing just the characters '(' and ')',
    * find the length of the longest valid (well-formed) parentheses substring.
    * */

    public int longestValidParentheses(String s) {
        int max=0;
        Stack<Integer> stack=new Stack<>();
        int start=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='('){
                stack.push(i);
            }else{
                if(cur==')'){
                    if(!stack.empty()){
                        stack.pop();
                        max=Math.max(i-start,max);
                    }else{
                        start=i;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println("(((()())()()))()(()))".length());
    }
}

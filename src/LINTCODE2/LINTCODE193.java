package LINTCODE2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE193 {

    /*Description
    * Given a string containing just the characters '(' and ')',
    * find the length of the longest valid (well-formed) parentheses substring.
    * */

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='('){
                stack.push(1);
            }else{
                if(cur==')'){
                    if(stack.isEmpty()||stack.peek()==0)
                        stack.push(0);
                    else{
                        if(stack.peek()==1){
                            stack.pop();
                            if(stack.empty())
                                stack.push(2);
                            else{
                                if(stack.peek()>=2){
                                    int currLength =stack.pop();
                                    stack.push(currLength+2);
                                }else{
                                    stack.push(2);
                                }
                            }
                        }
                        else if(stack.peek()==0)
                            stack.push(0);
                        else{
                            int post=stack.pop();
                            if(stack.empty()||stack.peek()==0){
                                stack.push(post);
                                stack.push(0);
                            }else if(stack.peek()==1){
                                stack.pop();
                                post+=2;
                                if(!stack.empty()&&stack.peek()>=2){
                                    post+=stack.pop();
                                }
                                stack.push(post);
                            }
                        }
                    }
                }
            }
        }
        int max=0;
        while(!stack.empty()){
            max=Math.max(stack.pop(),max);
        }
        return max==1?0:max;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("((()))())"));
    }
}

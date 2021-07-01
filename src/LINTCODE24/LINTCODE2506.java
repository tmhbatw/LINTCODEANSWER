package LINTCODE24;

import java.util.LinkedList;
import java.util.Stack;

public class LINTCODE2506 {
    /*Description
    *你将得到一个由小写字母 a-z ，左括号 '(' 和右括号 ')' 构成的字符串 s。
    * 你的任务是删除尽可能少的括号，使得 s 里面的括号匹配。
    * 你需要返回删除括号后的字符串。
    * 由于答案可能会有很多，所以你只需要返回任意一个正确答案。
    * 例如："()", "(())", "()()", "(())()" 是括号匹配的字符串， 而 ")(", "(()", "()()(", "()())" 则是括号不匹配的字符串。
    * */

    public String removeParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        boolean[] exist=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.add(i);
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty()) {
                    exist[stack.pop()] = true;
                    exist[i]= true;
                }
            }else
                exist[i]=true;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(exist[i])
                sb.append(s.charAt(i));
        }
        return sb.toString();
        // write your code here.
    }
}

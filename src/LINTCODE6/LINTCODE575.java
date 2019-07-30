package LINTCODE6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE575 {
    /*Description
    *给出一个表达式 s，此表达式包括数字，字母以及方括号。
    * 在方括号前的数字表示方括号内容的重复次数(括号内的内容可以是字符串或另一个表达式)，请将这个表达式展开成一个字符串。
    * */

    public static String expressionExpand(String s) {
        Deque<Character> deque=new ArrayDeque<>();
        Stack<Integer> times=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(s.charAt(i)==']'){
                String cur="";
                while(deque.peekLast()!='['){
                    cur+=deque.pollLast();
                }
                deque.pollLast();
                int time=times.pop();
                while(time-->0){
                    for(int j=cur.length()-1;j>=0;j--)
                        deque.addLast(cur.charAt(j));
                }
            }else if(c<='9'&&c>='0'){
                int cur=c-'0';
                char next=s.charAt(i+1);
                while(next<='9'&&next>='0'){
                    i=i+1;

                    cur=cur*10+(next-'0');
                    next=s.charAt(i+1);
                }
                times.push(cur);
            }else
                deque.addLast(s.charAt(i));
        }
        StringBuffer sb=new StringBuffer();
        while(!deque.isEmpty())
            sb.append(deque.pollFirst());
        return sb.toString();
        // write your code here
    }


    public static void main(String[] args){
        System.out.println(expressionExpand("20[abcde]"));

    }
}

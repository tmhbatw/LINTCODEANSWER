package LINTCODE17;

import java.util.List;
import java.util.Stack;

public class LINTCODE1645 {
    /*Description
    * 给一个由 n 个整数组成的数组。将它拆分为多个严格递减的子序列。输出通过拆分可以获得的最小子序列数。
    * */

    public int LeastSubsequences(List<Integer> arrayIn) {
        Stack<Integer> stack=new Stack<>();
        for(int num:arrayIn){
            if(stack.isEmpty()||num>=stack.peek())
                stack.push(num);
            else{
                Stack<Integer> cur=new Stack<>();
                while(!stack.isEmpty()&&stack.peek()>num){
                    cur.push(stack.pop());
                }
                cur.pop();
                stack.push(num);
                while(!cur.isEmpty())
                    stack.push(cur.pop());
            }
        }
        return stack.size();
    }

    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack);
        Stack<Integer> stack2=new Stack<>();
        stack2.addAll(stack);
        System.out.println(stack2);
    }
}

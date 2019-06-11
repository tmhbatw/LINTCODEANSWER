package LINTCODE5;

import java.util.Stack;

public class LINTCODE419 {
    /*Description
    * 给定一个罗马数字，将其转换成整数。
    * */

    /*Solution
    * 压入栈中进行计算
    * */

    public int romanToInt(String s) {
        Stack<Character> stack=new Stack<>();
        int result=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            while(!stack.empty()&&getNumber(stack.peek())>getNumber(curr)){
                result+=getNumber(stack.pop());
            }
            while(!stack.empty()&&getNumber(stack.peek())<getNumber(curr)){
                result-=getNumber(stack.pop());
            }
            stack.add(s.charAt(i));
        }
        while(!stack.empty())
            result+=getNumber(stack.pop());
        return result;
        // write your code here
    }

    private int getNumber(char curr){
        switch(curr){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
}

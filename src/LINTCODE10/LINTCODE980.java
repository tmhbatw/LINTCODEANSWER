package LINTCODE10;

import java.util.Stack;

public class LINTCODE980 {
    /*Description
    * 实现一个基础计算器来计算一个简单表达式字符串。
    * 这个表达式字符串只包含 非负 整数，运算符 +, -, *, / 以及空格 。 整数除法应该舍去小数。
    * 你可以假设给出的表达式总是合理的。
    * */

    public int calculate(String s) {
        Stack<Character> characterStack=new Stack<>();
        Stack<Integer> numberStack=new Stack<>();
        int length=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            switch (cur){
                case ' ':
                    break;
                case '+':
                    while(!characterStack.empty()){
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    }
                    characterStack.add('+');
                    break;
                case '-':
                    while(!characterStack.empty()){
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    }
                    characterStack.add('-');
                    break;
                case '*':
                    if(!characterStack.empty()&&(characterStack.peek()=='*'||characterStack.peek()=='/')){
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    }
                    characterStack.add('*');
                    break;
                case '/':
                    if(!characterStack.empty()&&(characterStack.peek()=='*'||characterStack.peek()=='/')){
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    }
                    characterStack.add('/');
                    break;
                default:
                    int curr=cur-'0';
                    while(i<length-1&&(isNumber(s.charAt(i+1))||s.charAt(i+1)==' ')){
                        char c=s.charAt(++i);
                        if(c==' ')
                            continue;
                        curr=curr*10+c-'0';
                    }
                    numberStack.add(curr);
            }

            System.out.println(numberStack+" "+characterStack);
        }
        while(!characterStack.empty()){
            numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop())); }
        return numberStack.pop();
        // Write your code here
    }

    private boolean isNumber(char cur){
        return cur<='9'&&cur>='0';
    }

    private int getRes(char cur,int i1,int i2){
        switch (cur){
            case '+':
                return i1+i2;
            case '-':
                return i2-i1;
            case '*':
                return i1*i2;
            default:
                return i2/i1;
        }
    }
}

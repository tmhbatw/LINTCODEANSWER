package LINTCODE10;

import java.util.Stack;

public class LINTCODE978 {
    /*Description
    *实现一个基础的计算器来计算一个简单表达式。
    * 这个表达式字符串可能包含左括号 '(' 与右括号 ')'，加号 '+' 或者 减号 '-'，非负整数以及空格 ' '。
    * 给出的表达式总是合理的。
    * */

    public int calculate(String s) {
        Stack<Character> characterStack=new Stack<>();
        Stack<Integer> numberStack=new Stack<>();
        numberStack.add(0);
        int length=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            switch (cur){
                case ' ':
                    break;
                case '(':
                    characterStack.add('(');
                    break;
                case ')':
                    while(characterStack.peek()!='('){
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    }
                    numberStack.pop();
                    break;
                case '+':
                    while(!characterStack.empty()&&characterStack.peek()!='(')
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    characterStack.add('+');
                    break;
                case '-':
                    while(!characterStack.empty()&&characterStack.peek()!='(')
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    characterStack.add('-');
                    break;
                default:
                    int curr=cur-'0';
                    while(i<length-1&&isNumberOrSpace(s.charAt(i+1))){
                        char c=s.charAt(++i);
                        if(c==' ')
                            continue;
                        curr=curr*10+c-'0';
                    }
                    numberStack.add(curr);
            }
        }
        while(!characterStack.empty()){
            numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
        }
        return numberStack.pop();
        // Write your code here
    }

    private boolean isNumberOrSpace(char cur){
        return (cur==' '||cur<='9'&&cur>='0');
    }

    private int getRes(char cur,int i1,int i2){
        switch (cur){
            case '+':
                return i1+i2;
            case '-':
                return i2-i1;
        }
        return 0;
    }
}

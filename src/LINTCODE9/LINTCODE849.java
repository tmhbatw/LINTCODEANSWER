package LINTCODE9;

import java.util.Stack;

public class LINTCODE849 {
    /*Description
    * 实现一个基本的计算器来计算一个简单的表达式字符串。
    * 表达式字符串可以包含左括号 (和右括号 )、加号+或减号-、非负 整数和空格。
    * 表达式字符串只包含非负整数、+, -, *, /操作符、左括号 (，右括号 )和空格。
    * 您可以假设给定的表达式总是有效的。所有中间结果将在“[-2147483648,2147483647]”范围内。
    * */

    public int calculate(String s) {
        Stack<Integer> numberStack=new Stack<>();
        Stack<Character> characterStack=new Stack<>();
        int sLength=s.length();
        for(int i=0;i<sLength;i++){
            char cur=s.charAt(i);
            switch (cur){
                case '+':
                case '-':
                case '*':
                case '/':
                    int level=getLevel(cur);
                    while(!characterStack.empty()&&getLevel(characterStack.peek())>=level)
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    characterStack.add(cur);
                    break;
                case '(':
                    characterStack.add('(');
                    break;
                case ')':
                    while(characterStack.peek()!='(')
                        numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
                    characterStack.pop();
                    break;
                case ' ':
                    break;
                default:
                    int curr=cur-'0';
                    while(i<sLength-1&&isNumberOrSpace(s.charAt(i+1))){
                        char c=s.charAt(++i);
                        if(c!=' ')
                            curr=curr*10+c-'0';
                    }
                    numberStack.add(curr);
            }
        }
        while(!characterStack.empty())
            numberStack.add(getRes(characterStack.pop(),numberStack.pop(),numberStack.pop()));
        return numberStack.pop();
        // Write your code here
    }

    private boolean isNumberOrSpace(char cur){
        return cur==' '||cur<='9'&&cur>='0';
    }

    private int getLevel(char cur){
        switch(cur){
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
        }
        return 0;
    }

    private int getRes(char cur,int i1,int i2){
        switch (cur){
            case '+':return i1+i2;
            case '-':return i2-i1;
            case '*':return i2*i1;
            case '/':return i2/i1;
        }
        return 0;
    }
}

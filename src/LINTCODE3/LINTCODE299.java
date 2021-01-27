package LINTCODE3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE299 {
    /*Description
    * 小千在教弟弟小泉打字，可是弟弟老是打错，当弟弟打错时，小千总是会按下'<'符号，表示删除错误的一个字符。（'<'代表回退backspace）
    * 小泉现在是初级水平，所以他打的字符均是小写字母。
    * 请问删除错误的字符后，正确的结果是什么呢？
    * */

    public String getTextcontent(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='<')
                stack.push(c);
            else{
                if(!stack.empty())
                    stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty())
            sb.append(stack.pop());
        return sb.reverse().toString();
        // write your code here.
    }
}

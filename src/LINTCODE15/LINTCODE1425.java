package LINTCODE15;

import java.util.Stack;

public class LINTCODE1425 {
    /*Description
    * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
    * 判断二者是否相等，并返回结果。 # 代表退格字符。
    * */

    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
        // Write your code here
    }

    private String getString(String cur){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            if(curr=='#'&&!stack.empty())
                stack.pop();
            if(curr!='#')
                stack.push(curr);
        }
        String res="";
        while(!stack.empty())
            res=stack.pop()+res;
        return res;
    }
}

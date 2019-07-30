package LINTCODE9;

import java.util.Stack;

public class LINTCODE823 {
    /*Description
    *给出两个输入流inputA和inputB(包含退格符),如果两个输入流最后的结果相等，输出YES，否则输出NO。
    * */

    public String inputStream(String inputA, String inputB) {
        if(getRes(inputA).equals(getRes(inputB)))
            return "YES";
        return "NO";
        // Write your code here
    }

    private String getRes(String cur){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            if(curr=='<'){
                if(s.empty())
                    continue;
                else
                    s.pop();
            }else
                s.add(curr);
        }
        StringBuffer sb=new StringBuffer();
        while(!s.empty())
            sb.append(s.pop());
        return sb.toString();
    }
}

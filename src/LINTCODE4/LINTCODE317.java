package LINTCODE4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LINTCODE317 {
    /*Description
    * 给一个含有'('，')'，'*'的字符串，允许把'*'变为'('或')'或''，求最短的括号匹配合法序列，
    * 若有多个答案，返回字典序最小的那个。若不存在解则返回“No solution!”。
    * */


    public String minimumParenthesesMatching(String s) {
        int minLeft=0,maxLeft=0;
        String noSolution="No solution!";
        //第一步判断s是否能够成为这样的一个字符串
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    minLeft++;
                    maxLeft++;
                    break;
                case ')':
                    maxLeft--;
                    if(maxLeft<0)
                        return noSolution;
                    minLeft=Math.max(0,minLeft-1);
                    break;
                default:
                    minLeft=Math.max(0,minLeft-1);
                    maxLeft++;
            }
        }
        if(minLeft>0)
            return noSolution;
        int leftNumber=0;
        Deque<Integer> stack=new ArrayDeque<>();
        char[] res=new char[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    leftNumber++;
                    res[i]='(';
                    break;
                case ')':
                    leftNumber--;
                    if(leftNumber==-1){
                        res[stack.pollLast()]='(';
                        leftNumber++;
                    }
                    res[i]=')';
                    break;
                default:
                    stack.push(i);
            }
        }
        while(leftNumber>0){
            leftNumber--;
            res[stack.pop()]=')';
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length;i++)
            if(res[i]!='\u0000')
                sb.append(res[i]);
        return sb.toString();
        // write your code here
    }

    public static void main(String[] args){
        new LINTCODE317().minimumParenthesesMatching("((***)()((**");
    }
}

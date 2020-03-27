package LINTCODE16;

import java.util.Stack;

public class LINTCODE1560 {
    /*Description
    * 给定一个长度为n的只含小写字母的字符串s，从里面去掉k个字符，得到一个长度为n-k的新字符串。设计算法，输出字典序最小的新字符串。
    * 此题中字典序的定义：首先比较两个字符串的长度，长度小的字典序更小，如果长度相同，则从字符串左边开始逐位比较，找到第一位不同的字符，对应字符小的字符串的字典序更小。
    * 如："abbz"和"abza"，首先两个字符串的长度相同，则从左边开始逐位比较：
    * 第一位都是"a"，则继续比较下一位
    * 第二位都是"b"，则继续比较下一位
    * 第三位第一个字符串是"b"，而第二个字符串是"z"，因为"b" < "z"，故第一个字符串的字典序更小。
    * */

    public String MinimumString(char[] s, int k) {
        Stack<Character> stack=new Stack<>();
        int index=0;
        int length=s.length;
        while(index<length&&k>0){
            char cur=s[index++];
            while(!stack.isEmpty()&&k>0&&stack.peek()>cur) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        if(index==length)
            return sb.toString().substring(0,sb.length()-k);
        for(int i=index;i<length-k;i++)
            sb.append(s[i]);
        return sb.toString();
    }
}

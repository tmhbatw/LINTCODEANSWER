package LINTCODE3;

public class LINTCODE263 {
    /*Description
    * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')'， 判定是否是有效的括号序列。
    * 括号必须依照 "()" 顺序表示， "()" 是有效的括号，但 ")(" 则是无效的括号。
    * */

    public boolean matchParentheses(String string) {
        int left=0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='(')
                left++;
            else{
                left--;
                if(left<0)
                    return false;
            }
        }
        return left==0;
        // write your code here
    }
}

package LINTCODE15;

public class LINTCODE1491 {
    /*Description
    * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
    * () 得 1 分。
    * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
    * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
    * */

    public int scoreOfParentheses(String S) {
        if(S.length()==0)
            return 0;
        if(S.length()==2)
            return 1;
        int result=0;
        for(int i=0;i<S.length();i++){
            int start=i;
            int count=1;
            while(count!=0){
                i++;
                if(S.charAt(i)=='(')
                    count++;
                else
                    count--;
            }
            if(start==0&&i==S.length()-1)
                return 2*scoreOfParentheses(S.substring(1,S.length()-1));
            result+=scoreOfParentheses(S.substring(start,i+1));
        }
        return result;
        // Write your code here
    }
}

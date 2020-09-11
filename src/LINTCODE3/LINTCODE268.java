package LINTCODE3;

public class LINTCODE268 {
    /*Description
    * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
    * () 得 1 分。
    * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
    * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
    * */

    public int ParenthesesScore(String S) {
        if(S==null||S.length()==0)
            return 0;
        if(S.length()==2)
            return 1;
        int result=0;
        for(int i=0;i<S.length();i++){
            int time=1;
            int start=i;
            while(time!=0){
                i++;
                char cur=S.charAt(i);
                if(cur=='(')
                    time++;
                else
                    time--;
            }
            if(i-start==1)
                result+=1;
            else
                result+=2*ParenthesesScore(S.substring(start+1,i));
        }
        return result;
        // write your code here
    }
}

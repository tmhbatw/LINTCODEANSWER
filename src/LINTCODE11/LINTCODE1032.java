package LINTCODE11;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1032 {
    /*Description
    * 给定一个字符串S，我们可以将其中所有的字符任意切换大小写并得到一个新的字符串。
    * 将所有可生成的新字符串以一个列表的形式输出。
    * */


    public List<String> letterCasePermutation(String S) {
        String s=getLetterCase(S);
        List<String> result=new ArrayList<>();
        recursion(s,"",0,result);
        return result;
        // write your code here
    }

    private void recursion(String s,String curS,int curIndex,List<String> result){
        if(curIndex==s.length()){
            result.add(curS);
            return;
        }
        char cur=s.charAt(curIndex);
        if(cur<='9'&&cur>='0'){
            recursion(s,curS+cur,curIndex+1,result);
            return;
        }
        recursion(s,curS+cur,curIndex+1,result);
        recursion(s,curS+(char)(cur-'a'-'A'),curIndex+1,result);
    }

    private String getLetterCase(String S){
        StringBuilder s=new StringBuilder();
        for(int i=0;i<S.length();i++){
            char cur=S.charAt(i);
            if(cur<='Z'&&cur>='A')
                cur=(char)(cur+'a'-'A');
            s.append(cur);
        }
        return s.toString();
    }

}

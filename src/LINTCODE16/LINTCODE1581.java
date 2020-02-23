package LINTCODE16;

import java.util.Set;

public class LINTCODE1581 {
    /*Description
    * 给一个词典和一个字符串s，你只能删除s里的某些字符。你需要找到在词典里最长的可以生成的词，如果有多个，请输出字典序最小的一个。
    * */

    public String longestSubsequence(Set<String> dic, String s) {
        String result="";
        for(String cur:dic){
            if(cur.length()>s.length())
                continue;
            if(matched(s,cur)){
                if(cur.length()>result.length()||cur.length()==result.length()&&cur.compareTo(result)<0)
                    result=cur;
            }
        }
        return result;
        // Write your code here
    }

    private boolean matched(String s,String cur){
        int index=0;
        for(int i=0;i<s.length();i++){
            if(index==cur.length())
                return true;
            if(s.charAt(i)==cur.charAt(index))
                index++;
        }
        return index==cur.length();
    }
}

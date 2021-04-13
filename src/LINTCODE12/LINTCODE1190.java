package LINTCODE12;

import java.util.List;

public class LINTCODE1190 {
    /*Description
    *给定字符串和字符串字典，找到字典中可以通过删除给定字符串的某些字符所形成的最长字符串。
    * 如果有多个可能的结果，则返回具有最小字典顺序的最长单词。 如果没有可能的结果，则返回空字符串。
    * */

    public String findLongestWord(String s, List<String> d) {
        String result="";
        for(String cur:d){
            if(cur.length()<result.length())
                continue;
            if(isMatch(s,cur)){
                if(cur.length()>result.length()||cur.compareTo(result)<0)
                    result=cur;
            }
        }
        return result;
        // write your code  here
    }

    private boolean isMatch(String s,String cur){
        int index1=0,index2=0;
        while(index1<s.length()&&index2<cur.length()){
            if(s.charAt(index1)==cur.charAt(index2)){
                index1++;
                index2++;
            }else{
                index1++;
            }
        }
        return index2==cur.length();
    }
}

package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE194 {
    /*Description
    * 给定一个字符串str，和一个字典dict，你需要找出字典里的哪些单词是
    * 字符串的子序列，返回这些单词。
    * */

    public List<String> findWords(String str, List<String> dict) {
        List<String> list=new ArrayList<>();
        for(String cur:dict)
            if(contains(str,cur))
                list.add(cur);
            return list;
        // Write your code here.
    }

    private boolean contains(String str,String cur){
        int index=0;
        int i=0;
        while(i<str.length()){
            if(cur.charAt(index)==str.charAt(i)){
                index++;
            }
            if(index==cur.length())
                return true;
            i++;
        }
        return false;
    }
}

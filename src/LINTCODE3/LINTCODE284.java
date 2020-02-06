package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE284 {
    /*Description
    *给定字符串 source 和单词字典 words, 返回所有 words 中是 source 的子序列的单词。
    * */

    public List<String> MatchingSubsequences(String source, List<String> words) {
        List<String> result=new ArrayList<>();
        for(String cur:words)
            if(contains(source,cur))
                result.add(cur);
        return result;
        // write your code here
    }

    private boolean contains(String source,String cur){
        int index=0;
        int i=0;
        while(i<source.length()){
            if(cur.charAt(index)==source.charAt(i))
                index++;
            if(index==cur.length())
                return true;
            i++;
        }
        return false;
    }

}

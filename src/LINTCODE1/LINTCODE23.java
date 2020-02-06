package LINTCODE1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LINTCODE23 {
    /*Description
    * 给一字串s和单词的字典dict，请返回字典中所有是s的子序列的单词。
    * 子序列的定义是：如果字符串s通过去掉部分字母可以变成字符串t，那么t是s的子序列
    * */

    public List<String> wordSubsequence(String s, Set<String> wordDict) {
        List<String> result=new ArrayList<>();
        for(String cur:wordDict)
            if(contains(s,cur))
                result.add(cur);
        return result;
        // write your code here
    }

    private boolean contains(String s,String cur){
        int index=0;
        int i=0;
        int length=cur.length();
        while(i<s.length()){
            if(s.charAt(i)==cur.charAt(index))
                index++;
            if(index==length)
                return true;
            i++;
        }
        return false;
    }
}

package LINTCODE7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE671 {
    /*Description
    *如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 现在给出一个单词集合，需要统计这个集合中有多少种不同的循环单词。
    * */


    public int countRotateWords(List<String> words) {
        Set<String> set=new HashSet<>();
        for(String cur:words){
            String curcur=cur+cur;
            for(int i=0;i<cur.length();i++){
                set.remove(cur.substring(i,cur.length()+i));
            }
            set.add(cur);
        }
        return set.size();
        // Write your code here
    }
}

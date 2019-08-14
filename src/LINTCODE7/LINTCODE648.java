package LINTCODE7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LINTCODE648 {
    /*Description
    *假设你有一个字典和给你一个单词，判断这个单词的缩写在字典中是否是唯一的。
    * 当字典中的其他单词的缩写均与它不同的时候， 这个单词的缩写是唯一的.
    * */

    class ValidWordAbbr {
        /*
         * @param dictionary: a list of words
         */
        HashSet<String> set=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        public ValidWordAbbr(String[] dictionary) {
            for(String cur:dictionary){
                if(set.contains(cur))
                    continue;
                set.add(cur);
                if(cur.length()>2){
                    cur=cur.charAt(0)+""+(cur.length()-2)+cur.charAt(cur.length()-1);
                }
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
            // do intialization if necessary
        }

        /*
         * @param word: a string
         * @return: true if its abbreviation is unique or false
         */
        public boolean isUnique(String word) {
/*            if(!set.contains(word))
                return true;*/
            String cur="";
            if(word.length()>2)
                cur=word.charAt(0)+""+(word.length()-2)+word.charAt(word.length()-1);
            else{
                cur=word;
            }
            if(!map.containsKey(cur)||set.contains(word)&&map.get(cur)==1)
                return true;
            return false;
            // write your code here
        }
    }
}

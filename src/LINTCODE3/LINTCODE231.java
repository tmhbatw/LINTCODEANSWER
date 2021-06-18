package LINTCODE3;

import java.util.*;

public class LINTCODE231 {
    /*Description
    * 实现一个typeahead功能，给出一个字符串和一个包含若干个单词的字典，返回所有含有这个
    * 字符串子串的单词。字典不能被修改，并且这个方法可能被调用多次。
     * */
    public class Typeahead {
        /*
         * @param dict: A dictionary of words dict
         */

        Map<String,Set<String>> map;
        public Typeahead(Set<String> dict) {
            this.map=new HashMap<>();
            for(String cur:dict){
                for(int i=0;i<cur.length();i++){
                    for(int j=i+1;j<=cur.length();j++){
                        String substring=cur.substring(i,j);
                        map.putIfAbsent(substring,new HashSet<>());
                        Set<String> list=map.get(substring);

                        list.add(cur);
                    }
                }
            }
        }
        /*
         * @param str: a string
         * @return: a list of words
         */
        public List<String> search(String str) {
            if(map.containsKey(str))
                return new ArrayList<>(map.get(str));
            return new ArrayList<>();
        }
    }
}

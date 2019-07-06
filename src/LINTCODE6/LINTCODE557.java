package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE557 {
    /*Description
    *对一个字符串中的字符进行计数, 返回一个hashmap, key为字符, value是这个字符出现的次数.
    * */

    /*Solution
    * 考察对于hashMap的运用
    * */

    public Map<Character, Integer> countCharacters(String str) {
        Map<Character,Integer> result=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(result.containsKey(curr)){
                result.put(curr,result.get(curr)+1);
            }else{
                result.put(curr,1);
            }
        }
        return result;
        // write your code here
    }
}

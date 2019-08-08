package LINTCODE7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE638 {
    /*Description
    * 给定两个字符串 s 和 t ，确定它们是否是同构的。
    * 两个字符串是同构的如果 s 中的字符可以被替换得到 t。
    * 所有出现的字符必须用另一个字符代替，同时保留字符串的顺序。 没有两个字符可以映射到同一个字符，但一个字符可以映射到自己。
    * */

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(map.containsKey(cur)){
                if(map.get(cur)!=t.charAt(i))
                    return false;
            }else{
                if(set.contains(t.charAt(i)))
                    return false;
                else {
                    map.put(cur, t.charAt(i));
                    set.add(t.charAt(i));
                }
            }
        }
        return true;
        // write your code here
    }
}

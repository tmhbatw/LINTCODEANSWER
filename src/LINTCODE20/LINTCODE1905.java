package LINTCODE20;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1905 {
    /*Description
    * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
    * */

    public String CharacterDeletion(String str, String sub) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<sub.length();i++)
            set.add(sub.charAt(i));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(!set.contains(cur))
                sb.append(cur);
        }
        return sb.toString();
        // write your code here
    }
}

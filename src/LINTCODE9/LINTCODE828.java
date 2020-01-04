package LINTCODE9;

import java.util.HashMap;
import java.util.HashSet;

public class LINTCODE828 {
    /*Description
    * 给定一个模式串pattern和一个字符串str，请问str和pattern是否遵循相同的模式。
    * 这里遵循模式指的是一个完全匹配，即在pattern中的每个不同的字母和str中每个非空的单词之间有一个双向映射的模式对应。
    * */

    /*Solution
    * HashMap保存对应关系，判断是否符合相应模式
    * */

        public boolean wordPattern(String pattern, String teststr) {
            String[] str=teststr.split(" ");
            if(str.length!=pattern.length())
                return false;
            HashMap<String,Character> map=new HashMap<>();
            HashSet<Character> set=new HashSet<>();
            for(int i=0;i<str.length;i++){
                String cur=str[i];
                Character curChar=pattern.charAt(i);
                if(!map.containsKey(cur)){
                    if(set.contains(curChar))
                        return false;
                    map.put(str[i],curChar);
                    set.add(curChar);
                }else if(map.get(cur)!=pattern.charAt(i))
                    return false;
            }
            return true;
            // write your code here
        }
}

package LINTCODE15;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1411 {
    /*Description
    * 给定两个字符串s1和s2，找到最少的操作数以使得两个字符串相等。
在本题中，操作被定义为将一种字符“无限期“地替换为另一种字符。
    * */

    Map<Character,Character> map;
    public int editDistance(String s1, String s2) {
        map=new HashMap<>();
        int result=0;
        for(int i=0;i<s1.length();i++){
            char curs1=s1.charAt(i);
            if(!map.containsKey(curs1))
                map.put(curs1,curs1);
            char curs2=s2.charAt(i);
            if(!map.containsKey(curs2))
                map.put(curs2,curs2);
            char type1=getType(curs1);
            char type2=getType(curs2);
            if(type1!=type2){
                if(type1>type2){
                    char temp=type2;
                    type2=type1;
                    type1=temp;
                }
                map.put(type2,type1);
                result++;
            }
        }
        return result;
        // Write your code here
    }

    private char getType(char cur){
        if(map.get(cur)!=cur)
            return getType(map.get(cur));
        return cur;
    }
}

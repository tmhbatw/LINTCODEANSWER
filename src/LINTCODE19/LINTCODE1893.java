package LINTCODE19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LINTCODE1893 {
    /*Description
    * 如果字符串的所有字符出现的次数相同，则认为该字符串是有效的。如果我们可以在字符串的某1个索引处删除1个字符，
    * 并且其余字符出现的次数相同，那么它也是有效的。给定一个字符串s，判断它是否有效。如果是，返回YES，否则返回NO。
    * */

    public String isValid(String s) {
        int[] time=new int[26];
        for(int i=0;i<s.length();i++){
            time[s.charAt(i)-'a']++;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<26;i++) {
            if(time[i]!=0)
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }
        if(map.size()>=3)
            return "NO";
        if(map.size()==1)
            return "YES";
        int[] number=new int[2];
        int[] index=new int[2];
        int curIndex=0;
        System.out.println(map);
        for(Map.Entry entry:map.entrySet()){
            number[curIndex]= (int) entry.getKey();
            index[curIndex++]=(int)entry.getValue();
        }

        if(number[1]-number[0]==1&&index[1]==1||number[0]-number[1]==1&&index[0]==1||number[1]==1&&index[1]==1||number[0]==1&&index[0]==1)
            return "YES";
        return "NO";
        // write your code here
    }
}

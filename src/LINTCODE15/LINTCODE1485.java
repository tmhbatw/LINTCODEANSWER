package LINTCODE15;

import java.util.HashSet;

public class LINTCODE1485 {
    /*Description
    * 在圣杯世界里面，有一种隐藏咒语，这个咒语的秘密是一段英文中同时出现大小写的字母中最大的那一个，现在给你一段英文，你能把这个字母找出来嘛？
    * ps:一定存在答案
    * */

    public char holyGrailspell(String Spell) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<Spell.length();i++){
            set.add(Spell.charAt(i));
        }
        for(int i=0;i<26;i++){
            char cur= (char) ('Z'-i);
            if(set.contains(cur)&&set.contains((char)(cur+32)))
                return cur;
        }
        return 'A';
        // Write your code here
    }
}

package LINTCODE3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE250 {
    /*Description
    * 有一个双向配对的字母列表，比如：a<->t, b<->y, y<->h, h<->n, m<->w, w<->w …
    * 给定一个字符串，如果它是回文字符串，返回true。其中的字母可以被另一个对应的字母替换，但不允许嵌套替换，即a<-->b， b<-->c， 但a<-/->c。
    * 例如，字符串 “swims” 返回true，因为“w”可以被“m”替换，而字符串会变成“smims”，是回文字符串。
    * 字符串 “hob” 也返回true，因为“h”可以被“y”替换，“b”也可以被替换为“y”。然后字符串"yoy"也是回文。
    * 但是，字符串 “ban” 返回false，因为嵌套替换是不允许的。即使“b“可以变成“y“，“n“可以变成“h“，新的字符串“yah“也不是回文。
    * */

    public boolean ispalindrome(List<String> ambigram, String word) {
        HashSet<Character>[] sets=new HashSet[26];
        for(int i=0;i<26;i++) {
            sets[i] = new HashSet<>();
            sets[i].add((char)('a'+i));
        }
        for(String cur:ambigram){
            char first=cur.charAt(0);
            char second=cur.charAt(1);
            HashSet<Character> set1=sets[first-'a'];
            set1.add(second);
            HashSet<Character> set2=sets[second-'a'];
            set2.add(first);
        }
        int length=word.length();
        for(int i=0;i<length/2;i++){
            char first=word.charAt(i);
            char second=word.charAt(length-i-1);
            if(first==second)
                continue;
            Set<Character> set1=sets[first-'a'];
            Set<Character> set2=sets[second-'a'];
            boolean match=false;
            for(char cur:set1){
                if(set2.contains(cur)){
                    match=true;
                    break;
                }
            }
            if(!match)
                return false;
        }
        return true;
           // write your code here.
    }
}

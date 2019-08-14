package LINTCODE7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE647 {
    /*Description
    *给定一个字符串 s 和一个 非空字符串 p ，找到在 s 中所有关于 p 的字谜的起始索引。
    * 字符串仅由小写英文字母组成，字符串 s 和 p 的长度不得大于 40,000。
    * 输出顺序无关紧要。
    * */

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())
            return Collections.emptyList();
        int[] pnum=new int[26];
        for(int i=0;i<p.length();i++){
            pnum[p.charAt(i)-'a']++;
        }
        int[] snum=new int[26];
        for(int i=0;i<p.length();i++){
            snum[s.charAt(i)-'a']++;
        }
        List<Integer> list=new ArrayList<>();
        if(same(snum,pnum))
            list.add(0);
        for(int i=1;i<s.length()-p.length()+1;i++){
            snum[s.charAt(i-1)-'a']--;
            snum[s.charAt(i-1+p.length())-'a']++;
            if(same(snum,pnum))
                list.add(i);
        }
        return list;
        // write your code here
    }

    private boolean same(int[] snum,int[] pnum){
        for(int i=0;i<26;i++){
            if(snum[i]!=pnum[i])
                return false;
        }
        return true;
    }
}

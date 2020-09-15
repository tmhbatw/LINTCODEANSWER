package LINTCODE12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1169 {
    /*Description
    *给定两个字符串s1和s2，如果s2包含s1的排列，则写一个函数返回true。
    * 换句话说，第一个字符串的排列之一是第二个字符串的substring。
    * */

    public boolean checkInclusion(String s1, String s2) {
        int number=s1.length();
        int[] cc=new int[26];
        Set<Character> set=new HashSet<>();//用来存储s1中包含的字符种类
        for(int i=0;i<number;i++) {
            char cur=s1.charAt(i);
            cc[cur- 'a']++;
            set.add(cur);
        }
        for(int i=0;i<=s2.length()-number;i++){
            int[] c= cc.clone();
            int curNumber=number;
            int start=i;
            while(curNumber!=0){
                char cur=s2.charAt(start);
                if(!set.contains(cur))
                    break;
                if(c[cur-'a']>0){
                    c[cur-'a']--;
                    curNumber--;
                }else{
                    while(s2.charAt(i)!=cur){
                        curNumber++;
                        c[s2.charAt(i)-'a']++;
                        i++;
                    }
                }
                if(curNumber==0)
                    return true;
                start++;
            }
            i=start;
        }
        return false;
        // write your code here
    }
}

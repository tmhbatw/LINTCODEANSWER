package LINTCODE9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LINTCODE819 {
    /*Description
    * 给定一个新的字母表，如{c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}，根据新的字母表对一个字符串数组排序。
    * */

    public String[] wordSort(char[] alphabet, String[] words) {
        int[] num=new int[26];
        for(int i=0;i<alphabet.length;i++){
            num[alphabet[i]-'a']=i;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1=o1.length();
                int length2=o2.length();
                int length=Math.min(length1,length2);
                for(int i=0;i<length;i++){
                    char oo1=o1.charAt(i);
                    char oo2=o2.charAt(i);
                    if(oo1!=oo2)
                        return num[oo1-'a']-num[oo2-'a'];
                }
                return length1<length2?-1:1;
            }
        });
        return words;
        // Write your code here
    }
}

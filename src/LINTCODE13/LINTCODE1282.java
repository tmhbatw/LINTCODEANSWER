package LINTCODE13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1282 {
    /*Description
    *A、E、I、O、U
    * 写一个方法，接受给定字符串作为输入，并且只翻转字符串中的元音字母。
    * */

    public String reverseVowels(String s) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] str=s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
            if(!set.contains(str[left])){
                left++;
                continue;
            }
            if(!set.contains(str[right])){
                right--;
                continue;
            }
            char temp=str[left];
            str[left++]=str[right];
            str[right--]=temp;
        }
        return new String(str);
        // write your code here
    }
}

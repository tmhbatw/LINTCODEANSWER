package LINTCODE8;

public class LINTCODE773 {

    /*Description
    *有效的字母异位词
    * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    * */

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] cur=new char[128];
        for(int i=0;i<s.length();i++){
            cur[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            if(cur[t.charAt(i)]<=0)
                return false;
            cur[t.charAt(i)]--;
        }
        return true;
        // write your code here
    }
}

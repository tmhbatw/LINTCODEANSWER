package LINTCODE13;

public class LINTCODE1266 {
    /*Description
    * 给定两个只包含小写字母的字符串 s 和 t 。
    * 字符串 t 是由随机打乱字符顺序的字符串 s 在随机位置添加一个字符生成。
    * 找出在 t 中添加的字符。
    * */

    public char findTheDifference(String s, String t) {
        int[] time=new int[26];
        for(int i=0;i<t.length();i++)
            time[t.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++)
            time[s.charAt(i)-'a']--;
        for(int i=0;i<26;i++)
            if(time[i]==1)
                return (char)(i+'a');
            return 'b';
        // Write your code here
    }
}

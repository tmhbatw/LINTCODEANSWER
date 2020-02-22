package LINTCODE13;

public class LINTCODE1263 {
    /*Description
    * 给定字符串s和t，判断s是否为t的子序列。
    * 你可以认为在s和t中都只包含小写字母。t可能是一个非常长（length ~= 500,000）的字符串，而s是一个较短的字符串（length <= 100）。
    * 一个字符串的子序列是在原字符串中删去一些字符（也可以不删除）后，不改变剩余字符的相对位置形成的新字符串（例如，"ace"是"abcde"的子序列而"aec"不是）。
    * */

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int index=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(index))
                index++;
            if(index==s.length())
                return true;
        }
        return false;
        // Write your code here
    }
}

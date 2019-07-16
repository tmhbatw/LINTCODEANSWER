package LINTCODE8;

public class LINTCODE718 {
    /*Description
    *给定一个由 N 个字符构成的字符串 A和一个由 M 个字符构成的字符串 B,
    * 当A重复若干次之后能得到一个新的字符串，使得B是这个新字符串的子串，返回这个次数.如果A不管重复几次都不能使B成为它的子串，则返回-1
    * */


    public int repeatedString(String A, String B) {
        String a=A;
        for(int i=0;i<1000;i++){
            if(a.indexOf(B)!=-1)
                return i+1;
            a+=A;
        }
        return -1;
        // write your code here
    }
}

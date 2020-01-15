package LINTCODE14;

import java.util.Collections;

public class LINTCODE1343 {
    /*Description
    * 给定两个仅含数字的字符串，你需要返回一个由各个位之和拼接的字符串
    * */

    /*Solution
    * 给定两个仅含数字的字符串，你需要返回一个由各个位之和拼接的字符串
    * */

    public String SumofTwoStrings(String A, String B) {
        String a=A.length()>=B.length()?A:B;
        String b=A.length()<B.length()?A:B;
        System.out.println(a+" "+b);
        String result="";
        for(int i=0;i<a.length();i++){
            int curA=a.charAt(a.length()-1-i)-'0';
            int curB=i>=b.length()?0:b.charAt(b.length()-1-i)-'0';
            System.out.println(curA+" "+curB);
            int cur=curA+curB;
            result=cur+result;
        }
        return result;
        // write your code here
    }



    public static void main(String[] args){
        String cur="abc";
        System.out.println();
    }
}

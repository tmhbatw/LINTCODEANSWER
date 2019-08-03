package LINTCODE7;

public class LINTCODE627 {
    /*Description
    *给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
    * 数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
    * */

    public int longestPalindrome(String s) {
        int[] times=new int[128];
        for(int i=0;i<s.length();i++){
            times[s.charAt(i)]++;
        }
        int res=0;
        for(int i=0;i<128;i++){
            res+=times[i]/2*2;
        }
        return res<s.length()?res+1:res;
        // write your code here
    }
}

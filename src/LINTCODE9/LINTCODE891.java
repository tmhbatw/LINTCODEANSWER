package LINTCODE9;

public class LINTCODE891 {
    /*Description
    * 给一个非空字符串 s，你最多可以删除一个字符。判断是否可以把它变成回文串。
    * */

    public boolean validPalindrome(String s) {
        int length=s.length();
        for(int i=0;i<length/2;i++){
            if(s.charAt(i)!=s.charAt(length-i-1))
                return isPalindrome(s.substring(i,length-i-1))||isPalindrome(s.substring(i+1,length-i));
        }
        return true;
        // Write your code here
    }

    private boolean isPalindrome(String cur){
        int length=cur.length();
        for(int i=0;i<cur.length()/2;i++){
            if(cur.charAt(i)!=cur.charAt(length-i-1))
                return false;
        }
        return true;
    }
}

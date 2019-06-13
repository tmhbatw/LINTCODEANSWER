package LINTCODE5;

public class LINTCODE491 {

    /*Description
    * 判断回文数
    * */

    /*Solution
    * 与判断回文串相同
    * */

    public boolean isPalindrome(int num) {
        String s=String.valueOf(num);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
        // write your code here
    }
}

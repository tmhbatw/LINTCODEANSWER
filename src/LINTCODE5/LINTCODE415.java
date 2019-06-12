package LINTCODE5;

public class LINTCODE415   {
    /*Description
    * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    * */

    /*Solution
    * 判断从前往后与从后往前是否相同即可
    * 注意对于每一个字符的转化
    * */

    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(judge(s.charAt(i))=='*'){
                i++;
                continue;
            }
            if(judge(s.charAt(j))=='*'){
                j--;
                continue;
            }
            if(judge(s.charAt(i))!=judge(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
        // write your code here
    }

    private char judge(char curr){
        if(curr<='9'&&curr>='0'||curr<='z'&&curr>='a')
            return curr;
        if(curr<='Z'&&curr>='A')
            return (char) (curr-'A'+'a');
        return '*';

    }
}

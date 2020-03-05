package LINTCODE18;

public class LINTCODE1784 {
    /*Description
    *给定一个由 a-z 组成的字符串 s. 欲通过以下操作把 s 变成回文串:
    * 1. 把 'z' 变成 'y';
    * 2. 把 'y' 变成 'x';
    * 3. 把 'x' 变成 'w';
    * ................
    * 24. 把 'c' 变成 'b';
    * 25. 把 'b' 变成 'a';
    * 问把 s 变成回文串最少需要多少步操作?
    * */

    public int numberOfOperations(String s) {
        int left=0;
        int right=s.length()-1;
        int result=0;
        while(left<right){
            result+=Math.abs(s.charAt(right)-s.charAt(left));
            left++;
            right--;
        }
        return result;
        // Write your code here
    }
}

package LINTCODE2;

public class LINTCODE157 {
    /*Description
    * Implement an algorithm to determine if a string has all unique characters.
    * */

    /*Solution
    *可以创建一个128位数组存储然后进行判断，但是与挑战相反
    * 可以判断当前字符在余下字符串中是否出现过，算法复杂度较高，不与展示
    * */

    public boolean isUnique(String str) {
        int[] s=new int[128];
        for(int i=0;i<str.length();i++){
            if(s[str.charAt(i)]==1)
                return false;
            s[str.charAt(i)]++;
        }
        return true;
        // write your code here
    }
}

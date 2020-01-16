package LINTCODE13;

public class LINTCODE1283 {
    /*Description
    * 写一个方法，接受给定字符串作为输入，返回将这个字符串逐个字符翻转后的新字符串。
    * */

    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
        // write your code here
    }
}

package LINTCODE3;

public class LINTCODE241 {

    /*SDescription
    * 给一个字符串, 转换为整数. 你可以假设这个字符串是一个有效的整数的字符串形式， 且范围在32位整数之间 (-231 ~ 231 - 1)。
    * */

    /*Solution
    *直接通过API转化，也可以遍历字符串每一位
    * */

    public int stringToInteger(String str) {
        return Integer.parseInt(str);
        // write your code here
    }
}

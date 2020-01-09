package LINTCODE10;

public class LINTCODE977 {
    /*Description
    *给一个整数，返回其 7进制 的字符串表示
    * */

    /*Solution
    *递归
    * */

    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase7(num / 7) + num % 7;
    }
}

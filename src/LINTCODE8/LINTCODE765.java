package LINTCODE8;

public class LINTCODE765 {
    /*Description
    *给出三个整数 a, b, c, 如果它们可以构成三角形,返回 true.
    * */

    public boolean isValidTriangle(int a, int b, int c) {
        return a+b>c&&a+c>b&&b+c>a;
        // write your code here
    }
}

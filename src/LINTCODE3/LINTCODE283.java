package LINTCODE3;

public class LINTCODE283 {
    /*Description
    *给三个整数，求他们中的最大值。
    * */

    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        return Math.max(num1,Math.max(num2,num3));
        // write your code here
    }
}

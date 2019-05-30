package LINTCODE1;

public class LINTCODE37 {
    /*Description
    * Reverse a 3-digit integer.
    * */

    /*Solution
    * 翻转三位整数，没什么好说的= =
    * */
    public int reverseInteger(int number) {
        return number/100+(number/10%10)*10+number%10*100;
    }
}

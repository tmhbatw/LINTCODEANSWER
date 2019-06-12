package LINTCODE5;

public class LINTCODE413 {
    /*Description
    * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
    * */

    /*Solution
    * 直接转化为long型，效率极低思路清晰
    * */
    public int reverseInteger(int n) {
        String s=String.valueOf(Math.abs(n));
        Long l=Long.valueOf(String.valueOf(new StringBuffer(s).reverse()));
        if(n<0)
            l=-l;
        if(l>Integer.MAX_VALUE||l<Integer.MIN_VALUE)
            return 0;
        return Math.toIntExact(l);
        // write your code here
    }
}

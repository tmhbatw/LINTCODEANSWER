package LINTCODE2;

public class LINTCODE140 {
    /*Description
    * Calculate the an % b where a, b and n are all 32bit non-negative integers.
    * */

    /*Solution
    * 快速幂运算方法
    * 将n转化为一个二进制数字，n个位与1取&运算，如果为1那么result乘以a
    * n右移一位，a=a*a,继续上述运算，直到n为0时
    * */
    public int fastPower(int a, int b, int n) {
        long ans = 1;
        long aa = a % b;
        while(n>0){
            if(n % 2 == 1)
                ans = (ans * aa) % b;
            n >>= 1;
            aa = (aa * aa) % b;
        }
        return (int) ans%b;
    }
}

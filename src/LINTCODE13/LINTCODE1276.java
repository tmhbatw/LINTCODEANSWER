package LINTCODE13;

public class LINTCODE1276 {
    /*Description
    * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
    * */

    public int getSum(int a, int n) {
        if((a&n)==0)
            return a|n;
        return getSum(a^n,(a&n)<<1);
        // wirte your code here
    }
}

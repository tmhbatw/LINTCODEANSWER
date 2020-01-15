package LINTCODE14;

public class LINTCODE1347 {
    /*Description
    * 给定一个整数n，返回n!（n的阶乘）的尾随零的个数。
    * */

    public int trailingZeroes(int n) {
        int result=0;
        while(n>0){
            n/=5;
            result+=n;
        }
        return result;
        // write your code here
    }
}

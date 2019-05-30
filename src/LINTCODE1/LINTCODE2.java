package LINTCODE1;

public class LINTCODE2 {
    /*Description
    Write an algorithm which computes the number of trailing zeros in n factorial.
    * */

    /*Solution
    小学奥数题
    获取前n个数连续相乘只需要获得前n个数字中5的个数即可
    因为10=2*5 2的个数远远小于5的个数
    因为n个连续相乘的数字中出现了几个5，那么结果中就将出现几个0
    需要注意的是如25，125中分别包含了2个、3个数字5
    * */
    public long trailingZeros(long n) {
        long result=0;
        while(n>=5){
            result+=n/5;
            n/=5;
        }
        return result;
    }
}

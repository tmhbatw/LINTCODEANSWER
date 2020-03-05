package LINTCODE8;

public class LINTCODE771 {
    /*Description
    * 给定一个数n，返回该数的二阶阶乘。在数学中，正整数的二阶阶乘表示不超过这个正整数且与它有相同奇偶性的所有正整数乘积。
    * */

    public long doubleFactorial(int n) {
        long result=1;
        int start=1;
        if(n%2==0)
            start=2;
        for(int i=start;i<=n;i+=2)
            result*=i;
        return result;
        // Write your code here
    }
}

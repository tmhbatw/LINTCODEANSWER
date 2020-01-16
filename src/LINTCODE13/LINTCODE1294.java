package LINTCODE13;

public class LINTCODE1294 {
    /*Description
    * 给定一个整数，判断它是否为3的幂。
    * */

    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        while(n%3==0)
            n/=3;
        return n==1;
        // Write your code here
    }
}

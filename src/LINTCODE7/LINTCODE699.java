package LINTCODE7;

public class LINTCODE699 {
    /*Description
    * 给两个数字 n 和 k. 我们需要判断 n 是否可以写成 k 个素数的和.
    * */

    public boolean isSumOfKPrimes(int n, int k) {
        if(n<2*k)
            return false;
        if(k==1)
            return isPrime(n);
        if(k==2){
            return n%2==0||isPrime(n-2);
        }
        return true;
        // write your code here
    }

    private boolean isPrime(int n){
        if(n==2)
            return true;
        if(n%2==0||n<2)
            return false;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

package LINTCODE8;

public class LINTCODE728 {

    /*Description
    * 给一 正整数 n (1 <= n <= 10^18). 判断这个数是否正好只有 3 个不同的因子, 如果正好有 3 个不同的因子就返回 true, 否则返回 false
    * */

    public boolean isThreeDisctFactors(long n) {
        long sqrt= (long) Math.sqrt(n);
        if(sqrt*sqrt==n&&isPrime(sqrt))
            return true;
        return false;
        // write your code here
    }

    private boolean isPrime(long n){
        if(n%2==0)
            return false;
        for(long i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}

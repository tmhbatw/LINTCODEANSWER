package LINTCODE8;

public class LINTCODE792 {
    /*Description
    *给出质数n，输出它是第几个质数。
    * */

    public int kthPrime(int n) {
        if(n==2)
            return 1;
        return getSum(n)+2;

        // write your code here
    }

    private int getSum(int n){
        int res=0;
        for(int i=3;i<n;i+=2){
            if(isPrime(n))
                res++;
        }
        return res;
    }

    private boolean isPrime(int cur){
        for(int i=3;i<=(int)Math.sqrt(cur);i+=2){
            if(cur%i==0)
                return false;
        }
        return true;
    }
}

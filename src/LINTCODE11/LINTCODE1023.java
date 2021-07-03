package LINTCODE11;

public class LINTCODE1023 {
    /*Description
    * 令f(x) 为x!的末尾0的个数。（回顾一下：x! = 1 * 2 * 3 * ... * x，并且我们规定0! = 1）
    * 例如，f(3) = 0 因为 3! = 6 在末尾没有0，而 f(11) = 2 因为 11! = 39916800 在末尾有两个0。
    * 给定 K，找到有多少非负整数 x 满足 f(x) = K.
    * */

    public int preimageSizeFZF(int K) {
        return (int)(getStart(K+1)-getStart(K));
        // Write your code here
    }

    private long getStart(int k){
        long l=0,r=Long.MAX_VALUE/1000000000;
        while(l<r){
            long mid=l+(r-l)/2;
            long zero=getZero(mid);
            if(zero<k)
                l=mid+1;
            else
                r = mid;
        }
        return l;
    }

    private long getZero(long k){
        long res = 0;
        while(k>0){
            k/=5;
            res+=k;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE1023().getZero(Long.MAX_VALUE/1000000000));
    }
}

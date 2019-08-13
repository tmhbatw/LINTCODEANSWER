package LINTCODE8;

public class LINTCODE730 {
    /*Description
    * 给一整数 n, 我们需要求前n个自然数形成的集合的所有可能子集中所有元素的和。
    * */

    public int subSum(int n) {
        int res=0;
        double cur=Math.pow(2,n-1);
        while(n-->0){
            res+=n+1;
        }

        return (int)cur*res;
        // write your code here
    }
}

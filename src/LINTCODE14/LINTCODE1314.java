package LINTCODE14;

public class LINTCODE1314 {
    /*Description
    * 给定一个整数，写一个函数来确定它是否是2的幂。
    * */

    public boolean isPowerOfTwo(int n) {
        while(n>1){
            if(n%2==1)
                return false;
            n/=2;
        }
        return true;
        // Write your code here
    }
}

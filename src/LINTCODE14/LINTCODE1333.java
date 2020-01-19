package LINTCODE14;

public class LINTCODE1333 {
    /*Description
    * 颠倒给定的 32 位无符号整数的二进制位。
    * */

    public long reverseBits(long n) {
        int[] res=new int[32];
        for(int i=0;i<32;i++){
            res[i]= (int) (n%2);
            n/=2;
        }
        long result=0;
        for(int i=31;i>=0;i--){
            result+=res[i]*Math.pow(2,31-i);
        }
        return result;
        // write your code here
    }
}

package LINTCODE;

public class LINTCODE2 {
    public long trailingZeros(long n) {
        long result=0;
        while((n=n/5)!=0){
            result+=n;
        }
        return result;
        // write your code here, try to do it without arithmetic operators.
    }
}

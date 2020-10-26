package LINTCODE8;

public class LINTCODE729 {
    /*Description
    *给出两个数 A 和 B, 其中 B >= A. 我们需要计算结果 F 的最后一位数是什么,
    * 其中F = B! / A!(1 <= A, B <= 10^18, A 和 B 非常大)
    * */


    public int computeLastDigit(long A, long B) {
        int result=1;
        for(long i=A+1;i<=B;i++){
            int res=(int)i%10;
            result*=res;
            result%=10;
            if(result==0)
                return 0;
        }
        return result;
        // write your code here
    }

}

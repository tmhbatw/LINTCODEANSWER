package LINTCODE17;

public class LINTCODE1608 {

    /*Description
    *如果正整数可以被 A 或 B 整除，那么它是神奇的。
    * 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
    * */



    public int nthMagicalNumber(int N, int A, int B) {
        long l=0,r=Long.MAX_VALUE;
        while(l<r){
            long mid=l+(r-l)/2;
            if(getCount(mid,A,B,N)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return (int) (l%1000000007);
        // Write your code here.
    }


    //获取cur前有多少个神奇数字
    public boolean getCount(long cur,int A,int B,int N){
        long count1=cur/A;
        long count2=cur/B;
        long count3=cur/getLcd(A,B);
        long count = count1+count2-count3;
        return count>=N;
    }

    private long getLcd(int A,int B){
        int c=getC(Math.min(A,B),Math.max(A,B));
        return (long)(A)*B/c;
    }

    private int getC(int A,int B){
        if(B%A==0)
            return A;
        return getC(B%A,A);
    }
}

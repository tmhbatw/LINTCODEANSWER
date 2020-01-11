package LINTCODE18;

public class LINTCODE1745 {
    /*Description
    * 如果数组是单调递增或单调递减的，那么它是单调的。
    * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
    * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
    * */

    /*Solution
    * 用一个标志位标识递增或是递减
    * */

    public boolean isMonotonic(int[] A) {
        if(A.length<=1)
            return true;
        int flag=0;//0表示未赋值，-1表示递减，+1表示递增
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                if(flag==-1)
                    return false;
                if(flag==0)
                    flag=1;
            }else if(A[i]<A[i-1]){
                if(flag==1)
                    return false;
                if(flag==0)
                    flag=-1;
            }
        }
        return true;
        // Write your code here.
    }
}

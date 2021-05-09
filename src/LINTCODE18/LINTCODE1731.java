package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1731 {
    /*Description
    *给定一个整数数组 A，对于每个整数 A[i]，我们可以选择让 A[i] 加 K 或者减 K。
    * 在此过程之后，我们得到一个新的数组 newA
    * 返回 newA 的最大值和 newA 的最小值之间可能存在的最小差值。
    * */

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int result=A[A.length-1]-A[0];
        for(int i=0;i<A.length-1;i++){
            result=Math.min(result,Math.max(Math.max(A[i]-A[0],A[A.length-1]-A[i+1]),
                    Math.max(A[A.length-1]-A[0]-2*K,A[i]+K-A[i+1]+K)));
        }
        return result;
        // write your code here
    }
}

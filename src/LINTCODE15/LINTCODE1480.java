package LINTCODE15;

public class LINTCODE1480 {
    /*Description
    *给出两个数组，求它们的点积
    * */

    public int dotProduct(int[] A, int[] B) {
        if(A.length==0||A.length!=B.length)
            return -1;
        int result=0;
        for(int i=0;i<A.length;i++)
            result+=A[i]*B[i];
        return result;
        // Write your code here
    }
}

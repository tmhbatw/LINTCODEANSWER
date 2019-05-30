package LINTCODE1;

public class LINTCODE82 {
    /*Description
    *Given 2 * n + 1 numbers, every numbers occurs twice except one, find it.
    * */

    /*Solution
    * 相同的数亦或为0，将数组每一个数亦或之后则为所求的值
    * */
    public int singleNumber(int[] A) {
        int result=0;
        for(int i=0;i<A.length;i++)
            result=result^A[i];
        return result;
        // write your code here
    }
}

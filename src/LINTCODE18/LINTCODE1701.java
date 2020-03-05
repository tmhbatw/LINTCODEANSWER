package LINTCODE18;

public class LINTCODE1701 {
    /*Description
    *给定一个整数数组A，当且仅当它是一个有效的山形数组时返回true。
    * A是一个山形数组，当且仅当：
    * A.length> = 3
    * 存在0 <i <A.length - 1的i，使得：
    * A [0] <A [1] <... A [i-1] <A [i]
    * A [i]> A [i + 1]> ...> A [A.length - 1]
    * */

    public boolean validMountainArray(int[] A) {
        if(A.length<=2)
            return false;
        int left=0;
        while(left<A.length-1&&A[left+1]>A[left])
            left++;
        int right=A.length-1;
        while(right>=1&&A[right]<A[right-1])
            right--;
        return left==right;
        // Write your code here.
    }
}

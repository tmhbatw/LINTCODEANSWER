package LINTCODE11;

public class LINTCODE1037 {
    /*Description
    * 给定一个[0, 1, ...N - 1]的排列A，其中N是A的长度.
    * 全局逆序数是指满足0 <= i < j < N 且 A[i] > A[j]的数量.
    * 局部逆序数是指满足0 <= i < N 且 A[i] > A[i+1]的数量.
    * 如果全局逆序数和局部逆序数相等，返回true，否则返回false.
    * */

    public boolean isIdealPermutation(int[] A) {
        for(int i=0;i<A.length;i++){
            for(int j=i+2;j<A.length;j++){
                if(A[i]>A[j])
                    return false;
            }
        }
        return true;
        // Write your code here
    }
}

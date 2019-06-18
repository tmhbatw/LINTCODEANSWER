package LINTCODE6;

public class LINTCODE532 {

    /*Description
    *Reverse pair is a pair of numbers (A[i], A[j]) such that A[i] > A[j] and i < j. Given an array,
    * return the number of reverse pairs in the array.
    * */

    /*Solution
    * 可以使用归并排序的思路
    * 排序后找到当前排序数字的坐标进行计算即可
    * */

    public long reversePairs(int[] A) {
        long result=0;
        for(int i=0;i<A.length;i++){
            int count=A[i];
            for(int j=i+1;j<A.length;j++){
                if(A[j]<count)
                    result++;
            }
        }
        return result;
        // write your code here
    }
}

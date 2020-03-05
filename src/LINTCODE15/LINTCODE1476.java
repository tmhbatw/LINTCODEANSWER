package LINTCODE15;

public class LINTCODE1476 {
    /*Description
    *我们把符合下列属性的数组 A 称作山脉：A.length >= 3
    * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
    * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
    * */

    public int peakIndexInMountainArray(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(A[mid]>A[mid+1]&&A[mid]>A[mid-1])
                return mid;
            if(A[mid]>A[mid+1])
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
        // Write your code here
    }
}

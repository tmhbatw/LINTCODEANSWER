package LINTCODE;

public class LINTCODE75 {
    /*Description
    *你给出一个整数数组(size为n)，其具有以下特点：
    * 相邻位置的数字是不同的
    * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
    * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
    * */

    /*Solution
    * 时间复杂度要求比较高，使用二分法
    * 该题目只要求我们找到一个峰值点即可，那么我们可以使用二分法，当大于左边向右搜寻，当大于右边向左搜寻
    * 当左右两点聚集在一点后，可知这一点一定大于左边且大于右边
    * 一定是一个峰值点
    * 时间复杂度为O（logn)
    * */

    public int findPeak(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(A[mid]<A[mid+1])
                left=mid+1;
            else
                right=mid-1;
        }
        return right;
    }
}

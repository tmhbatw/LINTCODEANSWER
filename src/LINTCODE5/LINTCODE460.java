package LINTCODE5;

public class LINTCODE460 {
    /*Description
    * Given target, a non-negative integer k and an integer array A sorted in ascending order,
    * find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target.
    * Otherwise, sorted in ascending order by number if the difference is same.
    * */

    /*Solution
    * 二分法找到大于等于目标值的第一个位置
    * 排序输出即可
    * */

    public int[] kClosestNumbers(int[] A, int target, int k) {
        int left=0,right=A.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(A[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        left=right-1;
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            if(left<0){
                result[i]=A[right++];
            }else if(right>=A.length){
                result[i]=A[left--];
            }else {
                if (Math.abs(A[left] - target) <= A[right] - target)
                    result[i] = A[left--];
                else
                    result[i]=A[right++];
            }
        }
        return result;
        // write your code here
    }
}

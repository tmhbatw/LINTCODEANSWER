package LINTCODE1;

public class LINTCODE60 {
    /*Description
    * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    * You may assume NO duplicates in the array.
    * */

    /*Solution
    * 二分查询法即可
    * */

    public int searchInsert(int[] A, int target) {
        if(A.length<1)
            return 0;
        int left=0;
        int right=A.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(A[mid]==target)
                return mid;
            if(A[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left=A[left]>=target?left:left+1;
        return left;
        // write your code here
    }
}

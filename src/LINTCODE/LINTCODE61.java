package LINTCODE;

public class LINTCODE61 {

    /*Description
    *Given a sorted array of n integers, find the starting and ending position of a given target value.
    * If the target is not found in the array, return [-1, -1].
    * Challenge
    * O(log n) time.
    * */

    /*Solution
    * 二分查询法找到出现目标数字的左右位置即可
    * */

    public int[] searchRange(int[] A, int target) {
        if(A.length<1||target<A[0]||target>A[A.length-1]){
            return new int[]{-1,-1};
        }
        int left=-1,right=-1;
        int m=0,n=A.length-1;
        while(m<=n){
            int mid=(m+n)/2;
            //找到目标数字
            if(A[mid]==target&&(mid==0||A[mid-1]<A[mid])){
                left=mid;
                break;
            }else if(A[mid]>target||A[mid-1]==target){
                n=mid-1;
            }else{
                m=mid+1;
            }
        }
        m=0;
        n=A.length-1;
        while(m<=n){
            int mid=(m+n)/2;
            //找到目标数字
            if(A[mid]==target&&(mid==A.length-1||A[mid+1]>A[mid])){
                right=mid;
                break;
            }else if(A[mid]<target||A[mid+1]==target){
                m=mid+1;
            }else{
                n=mid-1;
            }
        }
        return new int[]{left,right};
        // write your code here
    }
}

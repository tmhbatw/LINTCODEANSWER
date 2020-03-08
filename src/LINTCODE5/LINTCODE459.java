package LINTCODE5;

public class LINTCODE459 {
    /*Description
    * 在一个排好序的数组 A 中找到 i 使得 A[i] 最接近 target
    * */

    public int closestNumber(int[] A, int target) {
        int left=0;
        int right=A.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(A[mid]==target||mid==0&&A[mid]>target||mid==A.length-1&&A[mid]<target)
                return mid;
            if(A[mid]>target&&A[mid-1]<target)
                return target-A[mid-1]<=A[mid]-target?mid-1:mid;
            if(A[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
        // write your code here
    }
}

package LINTCODE;

public class LINTCODE62 {
    /*Description
    * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
    * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。你可以假设数组中不存在重复的元素。
    * Challenge
    * O(logN) 时间限制
    * */

    /*Solution
    * 找到旋转的点进行左右两边两次二分查找即可
    * */

    public int search(int[] A, int target) {
        if(A.length==0)
            return -1;
        if(A[0]==target)
            return 0;
        int rorateIndex=0;
        int left=0,right=A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            System.out.println(left+"  "+right+"  "+mid);
            if(mid==A.length-1||A[mid]>A[mid+1]){
                rorateIndex=mid;
                break;
            }else if(A[0]<=A[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left=target>A[0]?0:rorateIndex+1;
        right=target>A[0]?rorateIndex:A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
        // write your code here
    }
}

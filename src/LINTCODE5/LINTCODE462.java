package LINTCODE5;

public class LINTCODE462 {
    /*Description
    * 给一个升序的数组，以及一个target，找到它在数组中出现的次数。
    * */

    public int totalOccurrence(int[] A, int target) {
        int left=0,right=A.length-1;
        int mid=0;
        boolean exist=false;
        while(left<=right){
            mid=left+(right-left)/2;
            if(A[mid]==target&&(mid==0||A[mid-1]<target)){
                exist=true;
                break;
            }
            if(A[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(!exist)
            return -1;
        left=0;
        right=A.length-1;
        int last=0;
        while(left<=right){
            last=left+(right-left)/2;
            if(A[last]==target&&(last==A.length-1||A[mid+1]>target))
                break;
            if(A[last]>target)
                right=last-1;
            else
                left=last+1;
        }
        System.out.println(last+" "+mid);
        return last-mid+1;
        // write your code here
    }
}

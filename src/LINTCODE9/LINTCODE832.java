package LINTCODE9;

public class LINTCODE832 {
    /*Description
    *给一个横向排序的且纵向也排序的的 n * m 的矩阵， 问里面有几个负数。
    * */

    public int countNumber(int[][] nums) {
        int result=0;
        int length=nums[0].length;
        int left=0,right=length-1;
        for(int[] cur:nums){
            int mid=0;
            while(left<=right) {
                mid=left+(right-left)/2;
                if (mid == 0 && cur[mid] >= 0)
                    return result;
                if(cur[mid]<0&&(mid==length-1||cur[mid+1]>=0))
                    break;
                if(cur[mid]>=0)
                    right=mid-1;
                else
                    left=mid+1;
            }
            result+=mid+1;
            left=0;
            right=mid;
        }
        return result;
        // Write your code here
    }
}

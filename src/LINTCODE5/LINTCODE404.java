package LINTCODE5;

public class LINTCODE404 {
    /*Description
    * 给定一个正整数数组 A 和一个区间. 返回和在给定区间范围内的子数组数量.
    * */

    public int subarraySumII(int[] A, int start, int end) {
        int l=0,r=0;
        int lSum=0,rSum=0;
        int length=A.length;
        int result=0;
        for(int i=0;i<length;i++){
            if(l<i){
                lSum+=A[i];
                l++;
            }
            if(r<i){
                rSum+=A[i];
                r++;
            }
            while(lSum<start&&l<length){
                lSum+=A[l++];
            }
            while(r<length&&rSum+A[r]<=end){
                rSum+=A[r++];
            }
            System.out.println(l+" "+r+" "+i);
            if(lSum>=start&&rSum<=end){
                result+=r-l+1;
            }
            lSum-=A[i];
            rSum-=A[i];
        }
        return result;
        // write your code here
    }
}

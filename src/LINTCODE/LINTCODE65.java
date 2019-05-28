package LINTCODE;

import java.util.BitSet;

public class LINTCODE65 {
    /*Description
    *There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
    * Challenge
    * The overall run time complexity should be O(log (m+n)).
    * */

    /*Solution
    *题目要求为时间复杂度为O(log(m+n))则想到二分法
    * 设中位数为第k个数（总数为偶数个情况时则为第K与第K+1个两数之和，思路一样）
    * 则找到数组A中的第k/2个数，以及B中的k/2个数，若两者相等，则此数为中位数
    * 若A[k/2]<B[k/2]则中位数在A数组的第k/2个数后面，递归
    * 若A[k/2]>B[k/2]则中位数在B数组的第k/2个数后面，递归
    * */


    public double findMedianSortedArrays(int[] A, int[] B) {
        //寻找第k大的数
        int k=(A.length+B.length)/2+1;

        if((A.length+B.length)%2==1) {
            return getMedian(A, 0, B, 0, k-1, k-1);
        }
        else{
            return (getMedian(A, 0, B, 0, k-1, k-1)+getMedian(A, 0, B, 0, k-2, k-2))/2;}
        // write your code here
    }
    private double getMedian(int[] A,int startA,int[] B,int startB,int k,int last){
        if(last==0){
            if(startA>=A.length)
                return B[startB];
            if(startB>=B.length)
                return A[startA];
            return Math.min(A[startA],B[startB]);
        }
        if(last==1){
            if(startA>=A.length) {
                return B[startB + 1];
            }else if(startB>=B.length){
                return A[startA+1];
            }else if(A[startA]==B[startB]||A[startA]>B[startB]&&(startB==B.length-1||B[startB+1]>A[startB]))
                return A[startA];
            else if(A[startA]<B[startB]&&(startA==A.length-1||A[startA+1]>B[startB]))
                return B[startB];
            else if (A[startA] < B[startB] && A[startA + 1] < B[startB])
                return A[startA+1];
            return B[startB+1];
        }
        int partA=last%2==1?startA+last/2+1:startA+last/2;
        int partB=k-partA;
        if(partA>=A.length){
            return getMedian(A,startA,B,partB,k,last-(partB-startB));
        }
        if(A[partA]==B[partB])
            return A[partA];
        else if(A[partA]<B[partB])
            return getMedian(A,partA,B,startB,k,last-(partA-startA));
        else
            return getMedian(A,startA,B,partB,k,last-(partB-startB));
    }


    public static void main(String[] args){
        BitSet a=new BitSet(63);
        a.get(63);
        System.out.println(a);
    }


}

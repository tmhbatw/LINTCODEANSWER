package LINTCODE4;

import java.util.Arrays;

public class LINTCODE387 {

    /*Description
    * 给定两个整数数组（第一个是数组 A，第二个是数组 B），在数组 A 中取 A[i]，数组 B 中取 B[j]，
    * A[i] 和 B[j]两者的差越小越好(|A[i] - B[j]|), 返回最小差。
    * */

    /*Solution
    * 给A、B两数组排序，然后从头开始进行比较；
    * 如果A数组的数比较小，那么A向后移动，反之则B移动，记录最小差值，当差值为0直接返回
    * */


    public int smallestDifference(int[] A, int[] B) {
        int i=0,j=0;
        Arrays.sort(A);
        Arrays.sort(B);
        int result=Integer.MAX_VALUE;
        while(i<A.length&&j<B.length){
            result=Math.min(result,Math.abs(A[i]-B[j]));
            if(A[i]<B[j])i++;
            else j++;
            if(result==0)
                return 0;
        }
        return result;
        // write your code here
    }
}

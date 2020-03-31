package LINTCODE15;

public class LINTCODE1412 {
    /*Description
    * 给定p，q，r和数组a [0]，a [1]，...a [n-1]，计算p·a [i] + q·a [j] + r·a [k]的最大值，要求0≤i≤j≤k≤n-1。
    * */

    public long pickThreeNumbers(int p, int q, int r, int[] a) {
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max1=Math.max(max1, (long) p * a[i]);
            max2=Math.max(max2,max1+(long)q *a[i]);
            max3=Math.max(max3,max2+(long)r *a[i]);
        }
        return max3;
           // Write your code here
    }
}

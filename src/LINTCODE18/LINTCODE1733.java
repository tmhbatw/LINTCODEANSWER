package LINTCODE18;

public class LINTCODE1733 {
    /*Description
    * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
    * 在此过程之后，我们得到一些数组 B。
    * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
    * */

    public int smallestRangeI(int[] A, int K) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:A){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        return max-min>K*2?max-min-K-K:0;
        // write your code here
    }
}

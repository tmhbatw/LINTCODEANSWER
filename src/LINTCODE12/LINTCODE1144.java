package LINTCODE12;

public class LINTCODE1144 {
    /*Description
    *给定一个m * n 的全零矩阵M，以及一些更新操作。
    * 操作由2D数组表示，并且每个操作由具有两个正整数a和b的数组表示，
    * 对于一个操作[a,b],这意味着M [i] [j] 会在所有0 <= i <a且0 <= j <b 的i，j位置上加1.
    * 在执行完所有操作后，您需要计算并返回矩阵中的最大整数的个数。
    * */


    public int maxCount(int m, int n, int[][] ops) {
        for(int[] cur:ops){
            m=Math.min(m,cur[0]);
            n=Math.min(n,cur[1]);
        }
        return m*n;
        // write your code here
    }
}

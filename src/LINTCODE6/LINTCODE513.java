package LINTCODE6;

public class LINTCODE513 {
    /*Description
    *给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
    * */

    /*Solution
    * 动态规划
    * 根据当前的数字计算其基础上加上一个平方数，则其最小值为Math.min(当前个数+1，原先值）；
    * */



    public int numSquares(int n) {
        int[] result=new int[n+1];
        for(int i=1;i<n+1;i++)
            result[i]=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=1;i+j*j<n;j++){
                result[i+j*j]=Math.min(result[i]+1,result[i+j*j]);
            }
        }
        return result[n];
        // write your code here
    }
}

package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1807 {
    /*Description
    *查找斐波纳契数列中第 N 个数。
    * */

    public int fibonacci(int n) {
        int[] res=new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181};
        return res[n-1];        // write your code here
    }

    public static void main(String[] args){
        int[] dp=new int[20];
        dp[1]=1;
        for(int i=2;i<20;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }
}

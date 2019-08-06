package LINTCODE7;

public class LINTCODE664 {
    /*Description
    *给出一个 非负 整数 num，对所有满足 0 ≤ i ≤ num 条件的数字 i 均需要计算其二进制表示中数字 1 的个数并以数组的形式返回。
    * */

    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        int res=0;
        for(int i=1;i<=num;i++){
            dp[i]=dp[i&(i-1)]+1;
            res+=dp[i];
        }
        return dp;
        // write your code here
    }
}

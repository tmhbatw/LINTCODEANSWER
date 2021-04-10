package LINTCODE15;

public class LINTCODE1439 {
    /*Description
    *给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
    * */
    /*Solution
    * 以个数k来求值
    * */
    public int consecutiveNumbersSum(int N) {
        int result=1;
        for(int k=2;k<=Math.sqrt(N*2);k++){
            if((N-(k-1)*k/2)%k==0)
                result++;
        }
        return result;
        // Write your code here
    }

}

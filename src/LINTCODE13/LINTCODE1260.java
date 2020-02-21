package LINTCODE13;

public class LINTCODE1260 {
    /*Description
    给定一个整数数组A，令n等于其长度。
    令Bk为将A中元素顺时针旋转k个位置后得到的新数组，我们定义关于A的轮转函数F如下：
    F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
    计算F(0), F(1), ..., F(n-1)中的最大值。
    * */
    /*Solution
    * 递推关系为F[i] = F[i - 1] + sum - n * A[n - i]
    * */

    public int maxRotateFunction(int[] A) {
        int length=A.length;
        int sum=0;
        int[] dp=new int[length];
        for(int i=0;i<length;i++){
            sum+=A[i];
            dp[0]+=(i)*A[i];
        }
        int result=dp[0];
        for(int i=1;i<length;i++){
            dp[i]=dp[i-1]+sum-length*A[length-i];
            result=Math.max(result,dp[i]);
        }
        return result;
        // Write your code here
    }
}

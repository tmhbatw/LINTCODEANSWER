package LINTCODE9;

public class LINTCODE869 {
    /*Description
    * 在组合数学中，错乱是一组元素的排列，这种排列中没有元素出现在它的原始位置上。
    * 最初有一个由n个整数组成的数组，从1到n按升序排列，你需要找到它能生成的错乱的数量。
    * 由于答案可能非常大，您应该返回输出mod 10^9 + 7的结果
    * */

    public int findDerangement(int n) {
        long[] dp=new long[n+3];
        int mod=1000000007;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=i-1;
            dp[i]=(i-1)*(dp[i-1]+dp[i-2])%mod;
        }
        return (int)dp[n];
        // Write your code here
    }
}
